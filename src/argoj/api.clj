(ns argoj.api
  (:require [argo-workflows-api.core :refer [with-api-context]]
            [argo-workflows-api.api.workflow-service :as workflow]))

;;%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
;;              API
;;%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

;;; Workflow

(defn list-workflows
  "Return a list of all the running workflows and their
   definitions"
  {:added "0.1.0"}
  ([spec] (list-workflows spec (str)))
  ([spec ns]
   (with-api-context spec
     (let [{:keys [items] :as results}
           (workflow/workflow-service-list-workflows ns)]
       (assoc results :total (count items))))))


(defn create-workflow
  "Create a new workflow."
  {:added "0.1.0"}
  [spec workflow-spec]
  (with-api-context spec
    (workflow/workflow-service-create-workflow workflow-spec)))


(defn delete-workflow
  "Delete an existing Workflow"
  {:added "0.1.0"}
  ([spec workflow-name]
   (delete-workflow spec (str) workflow-name))
  ([spec ns workflow-name]
   (with-api-context spec
     (workflow/workflow-service-delete-workflow ns workflow-name))))


(defn get-workflow
  "Retrieve an existing Workflow"
  {:added "0.1.0"}
  ([spec workflow-name]
   (get-workflow spec (str) workflow-name))
  ([spec ns workflow-name]
   (with-api-context spec
     (workflow/workflow-service-get-workflow ns workflow-name))))


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
    (workflow/workflow-service-submit-workflow ns workflow-spec)))


(defn stop-workflow
  "Stop a running workflow"
  {:added "0.1.0"}
  ([spec workflow-name]
   (stop-workflow spec (str) workflow-name))
  ([spec ns workflow-name]
   (with-api-context spec
     (workflow/workflow-service-stop-workflow spec ns workflow-name))))

;;; To Implement
(comment
  (defn get-pod-log       [])
  (defn resubmit-workflow [])
  (defn resume-workflow   [])
  (defn retry-workflow    [])
  (defn set-workflow      [])
  (defn suspend-workflow  [])
  (defn terminate-workflow [])
  (defn watch-events       [])
  (defn watch-workflows    [])
  (defn workflows-logs     []))
