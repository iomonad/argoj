(ns argoj.admin
  (:require [argo-workflows-api.api.info-service :as ai]
            [argo-workflows-api.core :refer [with-api-context]]))

;;%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
;;             ADMIN
;;%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

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
