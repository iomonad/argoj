(ns user
  (:require [argo-workflows-api.core :refer :all]
            [clojure.tools.namespace.repl :refer :all]
            [argoj.api :as argo]
            [clojure.pprint :refer [pprint]]))

;;%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
;;              USER
;;%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%


(comment
  ;; API Testing

  (def spec (argo/mk-client {:token "eyJhbGciOiJSUzI1NiIsImtpZCI6IjNvRTh0NGM4Z2lnNDVia1ZGV0pYR2hOSjZYUHhzZW1qazQ4YW93XzFOa0kifQ.eyJpc3MiOiJrdWJlcm5ldGVzL3NlcnZpY2VhY2NvdW50Iiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9uYW1lc3BhY2UiOiJhcmdvIiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9zZWNyZXQubmFtZSI6Imd0ZWtwb3J0YWlsLWFwaS10b2tlbiIsImt1YmVybmV0ZXMuaW8vc2VydmljZWFjY291bnQvc2VydmljZS1hY2NvdW50Lm5hbWUiOiJndGVrcG9ydGFpbCIsImt1YmVybmV0ZXMuaW8vc2VydmljZWFjY291bnQvc2VydmljZS1hY2NvdW50LnVpZCI6IjJhZGEzM2M2LWJkNDUtNDMxYS1hN2Q5LWRmM2U5YTMyNjc2YiIsInN1YiI6InN5c3RlbTpzZXJ2aWNlYWNjb3VudDphcmdvOmd0ZWtwb3J0YWlsIn0.gnSoKdOmAgHfOsZB_lW7x9O8JT3z2hxQrUKOt9xfwEbtZWcFs4gORjC4X_CEQQxAdWZbfXz_CPKIu8TLpaK-_eNYlD4zMydpoUFKvW3iyaNjyiueyhuTwuN9jg-aJJvM9a7RoxkgGNOfTgZI4dQ4Xb-8sC62LDP9cVlg2sKtGdDhU-BmRPD3iGf911aiXXGRF2oOF_W_2CdrtBv1syLQE43p_StifcquHfEo0GtDgIxubH5qB04U-C4ywxxp4hNV0MTz8kWOKkFw7eyjLAYfspLPmSoG0XlDRVGohosltg86OjS8o5r06CHhDKcYOzTaT7Kuib1O_pShRX3gmS5QQA"}))

  (->> (argo/list-workflows spec "argo")
       pprint)

  (->> (argo/workflows-overview spec "argo")
       pprint)

  (->> (argo/get-workflow spec "argo" "dag-diamond-steps-jklmm")
       pprint)

  (->> (argo/get-workflow spec "argo" "dag-diamond-steps-828g"))

  (argo/purge-workflow spec "argo")

  (argo/create-workflow
   spec "argo"
   {:namespace "argo"
    :serverDryRun false
    :workflow
    {:metadata
     {:generateName "hello-world-"
      :namespace "argo"
      :labels #:workflows.argoproj.io{:completed "false"}}
     :spec
     {:templates
      [{:name "whalesay"
        :container
        {:name ""
         :image "docker/whalesay:latest"
         :command ["cowsay"]
         :args ["hello world"]
         :resources {}}}]
      :entrypoint "whalesay"}}})


  )
