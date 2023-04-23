(ns argoj.api
  (:require [argo-workflows-api.core :refer [with-api-context]]
            [argo-workflows-api.api.workflow-service :as workflow]
            [argo-workflows-api.api.cluster-workflow-template-service :as wt]
            [argo-workflows-api.api.event-service :as ev]
            [argo-workflows-api.api.event-source-service :as esv]
            [argo-workflows-api.api.cron-workflow-service :as cron]
            [argo-workflows-api.api.info-service :as ai]
            [schema.core :as s]
            [argoj.specs :refer :all]))

;;%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
;;              API
;;%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

;;; Helpers

(defn- coerce-ns [ns]
  (if (empty? ns) :all ns))


(defn- mk-query-params
  [m]
  (for [[k v] m] (str (name k) "=" v)))

;;; ===============================
;;;  Client
;;; ===============================

(defn mk-client
  [{:keys [token endpoint]}]
  (cond-> {}
    token (assoc :auths {"BearerToken" (str "Bearer " token)})
    endpoint (assoc :base-url endpoint)))

;;; ===============================
;;;  Workflows
;;; ===============================

(defn list-workflows
  "Return a list of all the running workflows and their
   definitions"
  {:added "0.1.0"}
  ([spec] (list-workflows spec (str)))
  ([spec ns]
   (with-api-context spec
     (let [{:keys [items] :as results}
           (workflow/workflow-service-list-workflows ns)]
       (assoc results
              :total (count items)
              :namespace (coerce-ns ns))))))


(defn search-workflows
  "Search running workflows with labels filters"
  {:added "0.3.3"}
  ([spec] (search-workflows spec {}))
  ([spec filters] (search-workflows spec (str) filters))
  ([spec ns filters]
   (with-api-context spec
     (let [{:keys [items] :as results}
           (workflow/workflow-service-list-workflows ns {:list-optionslabel-selector (mk-query-params filters)})]
       (assoc results
              :total (count items)
              :namespace (coerce-ns ns))))))


(defn workflows-overview
  "Return a quick overview of running workflows"
  {:added "0.1.0"}
  ([spec] (workflows-overview spec (str)))
  ([spec ns]
   (let [{:keys [items]} (list-workflows spec ns)]
     {:workflows (->> items
                      (map (fn [{:keys [metadata status]}]
                             (-> (select-keys metadata [:name])
                                 (merge (select-keys status [:startedAt :phase]))))))
      :namespace (coerce-ns ns)
      :total (count items)})))


(defn create-workflow
  "Create a new workflow."
  {:added "0.1.0"}
  [spec ns workflow-spec]
  (with-api-context spec
    (s/validate ArgoWorkflow workflow-spec)
    (workflow/workflow-service-create-workflow ns workflow-spec)))


(defn create-workflow!
  "Create a new workflow, without spec validation"
  {:added "0.3.5"}
  [spec ns workflow-spec]
  (with-api-context spec
    (workflow/workflow-service-create-workflow ns workflow-spec)))


(defn delete-workflow
  "Delete an existing Workflow"
  {:added "0.1.0"}
  ([spec workflow-name]
   (delete-workflow spec (str) workflow-name))
  ([spec ns workflow-name]
   (with-api-context spec
     (workflow/workflow-service-delete-workflow ns workflow-name)
     {:status :deleted
      :name workflow-name})))


(defn purge-workflow
  "Delete all workflows in current namespace"
  {:added "0.1.0"}
  [spec ns]
  (with-api-context spec
    (when-let [workflow-to-delete (some->> (workflows-overview spec ns)
                                           :workflows
                                           (map :name))]
      (let [total-ack (->> workflow-to-delete
                           (map (fn [wname]
                                  (delete-workflow spec ns wname)))
                           doall)]
        {:total (count total-ack)
         :deleted total-ack}))))


(defn get-workflow
  "Retrieve an existing Workflow"
  {:added "0.1.0"}
  ([spec workflow-name]
   (get-workflow spec (str) workflow-name))
  ([spec ns workflow-name]
   (with-api-context spec
     (let [{:keys [items] :as results}
           (workflow/workflow-service-get-workflow ns workflow-name)]
       (assoc results :total (count items))))))


(defn lint-workflow
  "Lint an existing Workflow"
  {:added "0.1.0"}
  ([spec workflow-spec]
   (lint-workflow spec (str) workflow-spec))
  ([spec ns workflow-spec]
   (with-api-context spec
     (workflow/workflow-service-lint-workflow ns workflow-spec))))


(defn submit-workflow
  "Submit a new workflow from spec"
  {:added "0.1.0"}
  [spec ns workflow-spec]
  (with-api-context spec
    (s/validate ArgoWorkflow workflow-spec)
    (workflow/workflow-service-submit-workflow ns workflow-spec)))


(defn stop-workflow
  "Stop a running workflow"
  {:added "0.1.0"}
  ([spec workflow-name]
   (stop-workflow spec (str) workflow-name))
  ([spec ns workflow-name]
   (with-api-context spec
     (workflow/workflow-service-stop-workflow spec ns workflow-name))))


(defn get-pod-log
  "Retrieve pod logs"
  {:added "0.1.1"}
  [spec ns workflow-name pod-name]
  (with-api-context spec
    (workflow/workflow-service-pod-logs ns workflow-name pod-name)))


(defn resubmit-workflow
  "Resubmit workflow"
  {:added "0.1.1"}
  [spec ns workflow-name workflow-spec]
  (with-api-context spec
    (s/validate ArgoWorkflowResubmit workflow-spec)
    (workflow/workflow-service-resubmit-workflow ns workflow-name workflow-spec)))


(defn suspend-workflow
  "Suspend a workflow"
  {:added "0.1.1"}
  ([spec ns name] (suspend-workflow spec ns name {}))
  ([spec ns name body]
   (with-api-context spec
     (workflow/workflow-service-suspend-workflow ns name body))))


(defn resume-workflow
  "Resume a workflow"
  {:added "0.1.1"}
  ([spec ns name] (resume-workflow spec ns name {}))
  ([spec ns name body]
   (with-api-context spec
     (workflow/workflow-service-resume-workflow ns name body))))


(defn retry-workflow
  "Retry a workflow"
  {:added "0.1.1"}
  ([spec ns name] (retry-workflow spec ns name {}))
  ([spec ns name body]
   (with-api-context spec
     (workflow/workflow-service-retry-workflow ns name body))))


(defn set-workflow
  "Set workflows properties & metadata"
  {:added "0.1.1"}
  [spec ns name body]
  (with-api-context spec
    (s/validate ArgoWorkflowSetter body)
    (workflow/workflow-service-set-workflow ns name body)))


(defn terminate-workflow
  "Terminate a workflow"
  {:added "0.1.1"}
  ([spec ns name] (terminate-workflow spec ns name {}))
  ([spec ns name body]
   (with-api-context spec
     (workflow/workflow-service-terminate-workflow ns name body))))


(defn watch-events
  "Watch namespace events

   Create a persistent connection"
  {:added "0.1.1"}
  [spec ns]
  (with-api-context spec
    (workflow/workflow-service-watch-events ns)))


(defn watch-workflows
  "Watch nampasce workflows events"
  {:added "0.1.1"}
  [spec ns]
  (with-api-context spec
    (workflow/workflow-service-watch-workflows ns)))


(defn workflows-logs
  "Retrieve Workflows logs"
  {:added "0.1.1"}
  ([spec ns workflow-name] (workflows-logs spec ns workflow-name {}))
  ([spec ns workflow-name params]
   (with-api-context spec
     (workflow/workflow-service-workflow-logs ns workflow-name ;params
                                              ))))

;;; ===============================
;;;  Templates
;;; ===============================

(defn list-templates
  "Retrieve Workflow Templates"
  {:added "0.1.1"}
  [spec]
  (with-api-context spec
    (wt/cluster-workflow-template-service-list-cluster-workflow-templates)))


(defn get-template
  "Retrieve Workflow Template by Name metadata"
  {:added "0.1.1"}
  [spec template-name]
  (with-api-context spec
    (wt/cluster-workflow-template-service-get-cluster-workflow-template template-name)))


(defn delete-template
  "Delete Workflow Template by name"
  {:added "0.1.1"}
  [spec template-name]
  (with-api-context spec
    (wt/cluster-workflow-template-service-delete-cluster-workflow-template template-name)))


(defn create-template
  "Create a new Workflow template"
  {:added "0.1.1"}
  [spec body]
  (with-api-context spec
    ;; TODO: Implement Template Spec
    ;;(s/validate ArgoWorkflowTemplate body)
    (wt/cluster-workflow-template-service-create-cluster-workflow-template body)))


(defn create-template
  "Update a Workflow template"
  {:added "0.1.1"}
  [spec template-name body]
  (with-api-context spec
    ;; TODO: Implement Template Spec
    ;;(s/validate ArgoWorkflowTemplate body)
    (wt/cluster-workflow-template-service-update-cluster-workflow-template template-name body)))

;;; ===============================
;;;  Admininistration
;;; ===============================

(defn cluster-info
  "Retrieve Cluster Info"
  {:added "0.1.1"}
  [spec]
  (with-api-context spec
    (ai/info-service-get-info)))


(defn user-info
  "Retrieve User Info"
  {:added "0.1.1"}
  [spec]
  (with-api-context spec
    (ai/info-service-get-user-info)))


(defn cluster-version
  "Retrieve Cluster Version & Build informations"
  {:added "0.1.1"}
  [spec]
  (with-api-context spec
    (ai/info-service-get-version)))

;;; ===============================
;;;  Events & Events Sources
;;; ===============================

(defn get-events-bindings
  "Retrieve Workflow events binding for the
   target namespace"
  {:added "0.1.1"}
  [spec ns]
  (with-api-context spec
    (ev/event-service-list-workflow-event-bindings ns)))


(defn create-events-binding
  "Create Workflow events binding.

  Optional discriminator for the io.argoproj.workflow.v1alpha1. This should almost always be empty.
  Used for edge-cases where the event payload alone is not provide enough information to discriminate the event.
  This MUST NOT be used as security mechanism, e.g. to allow two clients to use the same access token, or
  to support webhooks on unsecured server. Instead, use access tokens.

  The event itself can be any data."
  {:added "0.1.1"}
  [spec ns discriminator data]
  (with-api-context spec
    (ev/event-service-receive-event ns discriminator data)))


(defn list-event-sources
  {:added "0.1.1"}
  ([spec ns] (list-event-sources spec ns {}))
  ([spec ns options]
   (with-api-context spec
     (esv/event-source-service-list-event-sources ns options))))


(defn get-event-sources
  {:added "0.1.1"}
  ([spec ns name] (get-event-sources spec ns name {}))
  ([spec ns name options]
   (with-api-context spec
     (esv/event-source-service-get-event-source ns name options))))

;;; ===============================
;;;  CronJobs
;;; ===============================

(defn list-cronjobs
  "List cronjobs for the current namespace"
  {:added "0.1.1"}
  ([spec ns] (list-cronjobs spec ns {}))
  ([spec ns options]
   (with-api-context spec
     (cron/cron-workflow-service-list-cron-workflows ns options))))


(defn get-cronjob
  "Get cronjob by name"
  {:added "0.1.1"}
  ([spec ns name] (get-cronjob spec ns name {}))
  ([spec ns name options]
   (with-api-context spec
     (cron/cron-workflow-service-get-cron-workflow ns name options))))


(defn create-cronjob
  "Create cronjob"
  {:added "0.1.1"}
  [spec ns body]
  (with-api-context spec
    ;; TODO: Create Workflow Spec
    ;; (s/validate Fixme body)
    (cron/cron-workflow-service-create-cron-workflow ns body)))


(defn suspend-cronjob
  "Suspend Cronjob"
  {:added "0.1.1"}
  ([spec ns name] (suspend-cronjob spec ns name {}))
  ([spec ns name options]
   (with-api-context spec
     (cron/cron-workflow-service-suspend-cron-workflow ns name options))))


(defn resume-cronjob
  "Resume Cronjob"
  {:added "0.1.1"}
  ([spec ns name] (resume-cronjob spec ns name {}))
  ([spec ns name options]
   (with-api-context spec
     (cron/cron-workflow-service-resume-cron-workflow ns name options))))
