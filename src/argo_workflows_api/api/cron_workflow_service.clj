(ns argo-workflows-api.api.cron-workflow-service
  (:require [argo-workflows-api.core :refer [call-api check-required-params with-collection-format]])
  (:import (java.io File)))

(defn cron-workflow-service-create-cron-workflow-with-http-info
  ""
  [namespace body ]
  (call-api "/api/v1/cron-workflows/{namespace}" :post
            {:path-params   {"namespace" namespace }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    body
             :content-types ["application/json"]
             :accepts       ["application/json"]
             :auth-names    ["BearerToken"]}))

(defn cron-workflow-service-create-cron-workflow
  ""
  [namespace body ]
  (:data (cron-workflow-service-create-cron-workflow-with-http-info namespace body)))

(defn cron-workflow-service-delete-cron-workflow-with-http-info
  ""
  ([namespace name ] (cron-workflow-service-delete-cron-workflow-with-http-info namespace name nil))
  ([namespace name {:keys [delete-optionsgrace-period-seconds delete-optionspreconditionsuid delete-optionspreconditionsresource-version delete-optionsorphan-dependents delete-optionspropagation-policy delete-optionsdry-run ]}]
   (call-api "/api/v1/cron-workflows/{namespace}/{name}" :delete
             {:path-params   {"namespace" namespace "name" name }
              :header-params {}
              :query-params  {"deleteOptions.gracePeriodSeconds" delete-optionsgrace-period-seconds "deleteOptions.preconditions.uid" delete-optionspreconditionsuid "deleteOptions.preconditions.resourceVersion" delete-optionspreconditionsresource-version "deleteOptions.orphanDependents" delete-optionsorphan-dependents "deleteOptions.propagationPolicy" delete-optionspropagation-policy "deleteOptions.dryRun" (with-collection-format delete-optionsdry-run :multi) }
              :form-params   {}
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    ["BearerToken"]})))

(defn cron-workflow-service-delete-cron-workflow
  ""
  ([namespace name ] (cron-workflow-service-delete-cron-workflow namespace name nil))
  ([namespace name optional-params]
   (:data (cron-workflow-service-delete-cron-workflow-with-http-info namespace name optional-params))))

(defn cron-workflow-service-get-cron-workflow-with-http-info
  ""
  ([namespace name ] (cron-workflow-service-get-cron-workflow-with-http-info namespace name nil))
  ([namespace name {:keys [get-optionsresource-version ]}]
   (call-api "/api/v1/cron-workflows/{namespace}/{name}" :get
             {:path-params   {"namespace" namespace "name" name }
              :header-params {}
              :query-params  {"getOptions.resourceVersion" get-optionsresource-version }
              :form-params   {}
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    ["BearerToken"]})))

(defn cron-workflow-service-get-cron-workflow
  ""
  ([namespace name ] (cron-workflow-service-get-cron-workflow namespace name nil))
  ([namespace name optional-params]
   (:data (cron-workflow-service-get-cron-workflow-with-http-info namespace name optional-params))))

(defn cron-workflow-service-lint-cron-workflow-with-http-info
  ""
  [namespace body ]
  (call-api "/api/v1/cron-workflows/{namespace}/lint" :post
            {:path-params   {"namespace" namespace }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    body
             :content-types ["application/json"]
             :accepts       ["application/json"]
             :auth-names    ["BearerToken"]}))

(defn cron-workflow-service-lint-cron-workflow
  ""
  [namespace body ]
  (:data (cron-workflow-service-lint-cron-workflow-with-http-info namespace body)))

(defn cron-workflow-service-list-cron-workflows-with-http-info
  ""
  ([namespace ] (cron-workflow-service-list-cron-workflows-with-http-info namespace nil))
  ([namespace {:keys [list-optionslabel-selector list-optionsfield-selector list-optionswatch list-optionsallow-watch-bookmarks list-optionsresource-version list-optionsresource-version-match list-optionstimeout-seconds list-optionslimit list-optionscontinue ]}]
   (call-api "/api/v1/cron-workflows/{namespace}" :get
             {:path-params   {"namespace" namespace }
              :header-params {}
              :query-params  {"listOptions.labelSelector" list-optionslabel-selector "listOptions.fieldSelector" list-optionsfield-selector "listOptions.watch" list-optionswatch "listOptions.allowWatchBookmarks" list-optionsallow-watch-bookmarks "listOptions.resourceVersion" list-optionsresource-version "listOptions.resourceVersionMatch" list-optionsresource-version-match "listOptions.timeoutSeconds" list-optionstimeout-seconds "listOptions.limit" list-optionslimit "listOptions.continue" list-optionscontinue }
              :form-params   {}
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    ["BearerToken"]})))

(defn cron-workflow-service-list-cron-workflows
  ""
  ([namespace ] (cron-workflow-service-list-cron-workflows namespace nil))
  ([namespace optional-params]
   (:data (cron-workflow-service-list-cron-workflows-with-http-info namespace optional-params))))

(defn cron-workflow-service-resume-cron-workflow-with-http-info
  ""
  [namespace name body ]
  (call-api "/api/v1/cron-workflows/{namespace}/{name}/resume" :put
            {:path-params   {"namespace" namespace "name" name }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    body
             :content-types ["application/json"]
             :accepts       ["application/json"]
             :auth-names    ["BearerToken"]}))

(defn cron-workflow-service-resume-cron-workflow
  ""
  [namespace name body ]
  (:data (cron-workflow-service-resume-cron-workflow-with-http-info namespace name body)))

(defn cron-workflow-service-suspend-cron-workflow-with-http-info
  ""
  [namespace name body ]
  (call-api "/api/v1/cron-workflows/{namespace}/{name}/suspend" :put
            {:path-params   {"namespace" namespace "name" name }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    body
             :content-types ["application/json"]
             :accepts       ["application/json"]
             :auth-names    ["BearerToken"]}))

(defn cron-workflow-service-suspend-cron-workflow
  ""
  [namespace name body ]
  (:data (cron-workflow-service-suspend-cron-workflow-with-http-info namespace name body)))

(defn cron-workflow-service-update-cron-workflow-with-http-info
  ""
  [namespace name body ]
  (call-api "/api/v1/cron-workflows/{namespace}/{name}" :put
            {:path-params   {"namespace" namespace "name" name }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    body
             :content-types ["application/json"]
             :accepts       ["application/json"]
             :auth-names    ["BearerToken"]}))

(defn cron-workflow-service-update-cron-workflow
  ""
  [namespace name body ]
  (:data (cron-workflow-service-update-cron-workflow-with-http-info namespace name body)))

