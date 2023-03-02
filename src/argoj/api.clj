(ns argoj.api
  (:require [argo-workflows-api.core :refer :all]
            [argo-workflows-api.api.workflow-service :as workflow]))

;;%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
;;              API
;;%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

;;; Workflow

(defn create-workflow   [])
(defn delete-workflow   [])
(defn get-workflow      [])
(defn lint-workflow     [])
(defn get-pod-log       [])
(defn resubmit-workflow [])
(defn resume-workflow   [])
(defn retry-workflow    [])
(defn stop-workflow     [])
(defn set-workflow      [])
(defn submit-workflow   [])
(defn suspend-workflow  [])
(defn terminate-workflow [])
(defn watch-events       [])
(defn watch-workflows    [])
(defn workflows-logs     [])

(defn list-workflows
  "Return a list of all the running workflows"
  {:added "0.1.0"}
  ([spec] (list-workflows spec (str)))
  ([spec ns]
   (with-api-context spec
     (->> (workflow/workflow-service-list-workflows ns)
          :items))))
