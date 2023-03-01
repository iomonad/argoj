(ns argo-workflows-api.api.cluster-workflow-template-service
  (:require [argo-workflows-api.core :refer [call-api check-required-params with-collection-format]])
  (:import (java.io File)))

(defn cluster-workflow-template-service-create-cluster-workflow-template-with-http-info
  ""
  [body ]
  (call-api "/api/v1/cluster-workflow-templates" :post
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    body
             :content-types ["application/json"]
             :accepts       ["application/json"]
             :auth-names    ["BearerToken"]}))

(defn cluster-workflow-template-service-create-cluster-workflow-template
  ""
  [body ]
  (:data (cluster-workflow-template-service-create-cluster-workflow-template-with-http-info body)))

(defn cluster-workflow-template-service-delete-cluster-workflow-template-with-http-info
  ""
  ([name ] (cluster-workflow-template-service-delete-cluster-workflow-template-with-http-info name nil))
  ([name {:keys [delete-optionsgrace-period-seconds delete-optionspreconditionsuid delete-optionspreconditionsresource-version delete-optionsorphan-dependents delete-optionspropagation-policy delete-optionsdry-run ]}]
   (call-api "/api/v1/cluster-workflow-templates/{name}" :delete
             {:path-params   {"name" name }
              :header-params {}
              :query-params  {"deleteOptions.gracePeriodSeconds" delete-optionsgrace-period-seconds "deleteOptions.preconditions.uid" delete-optionspreconditionsuid "deleteOptions.preconditions.resourceVersion" delete-optionspreconditionsresource-version "deleteOptions.orphanDependents" delete-optionsorphan-dependents "deleteOptions.propagationPolicy" delete-optionspropagation-policy "deleteOptions.dryRun" (with-collection-format delete-optionsdry-run :multi) }
              :form-params   {}
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    ["BearerToken"]})))

(defn cluster-workflow-template-service-delete-cluster-workflow-template
  ""
  ([name ] (cluster-workflow-template-service-delete-cluster-workflow-template name nil))
  ([name optional-params]
   (:data (cluster-workflow-template-service-delete-cluster-workflow-template-with-http-info name optional-params))))

(defn cluster-workflow-template-service-get-cluster-workflow-template-with-http-info
  ""
  ([name ] (cluster-workflow-template-service-get-cluster-workflow-template-with-http-info name nil))
  ([name {:keys [get-optionsresource-version ]}]
   (call-api "/api/v1/cluster-workflow-templates/{name}" :get
             {:path-params   {"name" name }
              :header-params {}
              :query-params  {"getOptions.resourceVersion" get-optionsresource-version }
              :form-params   {}
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    ["BearerToken"]})))

(defn cluster-workflow-template-service-get-cluster-workflow-template
  ""
  ([name ] (cluster-workflow-template-service-get-cluster-workflow-template name nil))
  ([name optional-params]
   (:data (cluster-workflow-template-service-get-cluster-workflow-template-with-http-info name optional-params))))

(defn cluster-workflow-template-service-lint-cluster-workflow-template-with-http-info
  ""
  [body ]
  (call-api "/api/v1/cluster-workflow-templates/lint" :post
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    body
             :content-types ["application/json"]
             :accepts       ["application/json"]
             :auth-names    ["BearerToken"]}))

(defn cluster-workflow-template-service-lint-cluster-workflow-template
  ""
  [body ]
  (:data (cluster-workflow-template-service-lint-cluster-workflow-template-with-http-info body)))

(defn cluster-workflow-template-service-list-cluster-workflow-templates-with-http-info
  ""
  ([] (cluster-workflow-template-service-list-cluster-workflow-templates-with-http-info nil))
  ([{:keys [list-optionslabel-selector list-optionsfield-selector list-optionswatch list-optionsallow-watch-bookmarks list-optionsresource-version list-optionsresource-version-match list-optionstimeout-seconds list-optionslimit list-optionscontinue ]}]
   (call-api "/api/v1/cluster-workflow-templates" :get
             {:path-params   {}
              :header-params {}
              :query-params  {"listOptions.labelSelector" list-optionslabel-selector "listOptions.fieldSelector" list-optionsfield-selector "listOptions.watch" list-optionswatch "listOptions.allowWatchBookmarks" list-optionsallow-watch-bookmarks "listOptions.resourceVersion" list-optionsresource-version "listOptions.resourceVersionMatch" list-optionsresource-version-match "listOptions.timeoutSeconds" list-optionstimeout-seconds "listOptions.limit" list-optionslimit "listOptions.continue" list-optionscontinue }
              :form-params   {}
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    ["BearerToken"]})))

(defn cluster-workflow-template-service-list-cluster-workflow-templates
  ""
  ([] (cluster-workflow-template-service-list-cluster-workflow-templates nil))
  ([optional-params]
   (:data (cluster-workflow-template-service-list-cluster-workflow-templates-with-http-info optional-params))))

(defn cluster-workflow-template-service-update-cluster-workflow-template-with-http-info
  ""
  [name body ]
  (call-api "/api/v1/cluster-workflow-templates/{name}" :put
            {:path-params   {"name" name }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    body
             :content-types ["application/json"]
             :accepts       ["application/json"]
             :auth-names    ["BearerToken"]}))

(defn cluster-workflow-template-service-update-cluster-workflow-template
  ""
  [name body ]
  (:data (cluster-workflow-template-service-update-cluster-workflow-template-with-http-info name body)))

