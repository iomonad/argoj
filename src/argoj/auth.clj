(ns argoj.auth
  (:require [clj-http.client :as h]))

;;%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
;;               Auth
;;%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

(def ^:private
  default-opts
  {:as :json
   :content-type :json
   :debug :true})

(defn- authenticated*
  "Generic HTTP request wrapper for
   OAuth2 authentication."
  [method {:keys [endpoint token]}
   resource & {:keys [body params]}]
  (let [meth (condp = method
               :get   h/get
               :post  h/post
               :patch h/patch)]
    (->> (meth (str endpoint resource)
               (cond-> default-opts
                 params (assoc :query-params params)
                 body   (assoc :body body)
                 token  (update :headers merge {:authorization (str "Bearer " token)})))
         :body)))

;;; Implementations

(defn authenticated-get
  [ctx resource & extra]
  (authenticated* :get ctx resource extra))

(defn authenticated-post
  [ctx resource & extra]
  (authenticated* :post ctx resource extra))

(defn authenticated-patch
  [ctx resource & extra]
  (authenticated* :patch ctx resource extra))
