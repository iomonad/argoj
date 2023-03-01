(ns argo-workflows-api.api.workflow-template-service
  (:require [argo-workflows-api.core :refer [call-api check-required-params with-collection-format]])
  (:import (java.io File)))

(defn workflow-template-service-create-workflow-template-with-http-info
  ""
  [namespace body ]
  (call-api "/api/v1/workflow-templates/{namespace}" :post
            {:path-params   {"namespace" namespace }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    body
             :content-types ["application/json"]
             :accepts       ["application/json"]
             :auth-names    ["BearerToken"]}))

(defn workflow-template-service-create-workflow-template
  ""
  [namespace body ]
  (:data (workflow-template-service-create-workflow-template-with-http-info namespace body)))

(defn workflow-template-service-delete-workflow-template-with-http-info
  ""
  ([namespace name ] (workflow-template-service-delete-workflow-template-with-http-info namespace name nil))
  ([namespace name {:keys [delete-optionsgrace-period-seconds delete-optionspreconditionsuid delete-optionspreconditionsresource-version delete-optionsorphan-dependents delete-optionspropagation-policy delete-optionsdry-run ]}]
   (call-api "/api/v1/workflow-templates/{namespace}/{name}" :delete
             {:path-params   {"namespace" namespace "name" name }
              :header-params {}
              :query-params  {"deleteOptions.gracePeriodSeconds" delete-optionsgrace-period-seconds "deleteOptions.preconditions.uid" delete-optionspreconditionsuid "deleteOptions.preconditions.resourceVersion" delete-optionspreconditionsresource-version "deleteOptions.orphanDependents" delete-optionsorphan-dependents "deleteOptions.propagationPolicy" delete-optionspropagation-policy "deleteOptions.dryRun" (with-collection-format delete-optionsdry-run :multi) }
              :form-params   {}
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    ["BearerToken"]})))

(defn workflow-template-service-delete-workflow-template
  ""
  ([namespace name ] (workflow-template-service-delete-workflow-template namespace name nil))
  ([namespace name optional-params]
   (:data (workflow-template-service-delete-workflow-template-with-http-info namespace name optional-params))))

(defn workflow-template-service-get-workflow-template-with-http-info
  ""
  ([namespace name ] (workflow-template-service-get-workflow-template-with-http-info namespace name nil))
  ([namespace name {:keys [get-optionsresource-version ]}]
   (call-api "/api/v1/workflow-templates/{namespace}/{name}" :get
             {:path-params   {"namespace" namespace "name" name }
              :header-params {}
              :query-params  {"getOptions.resourceVersion" get-optionsresource-version }
              :form-params   {}
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    ["BearerToken"]})))

(defn workflow-template-service-get-workflow-template
  ""
  ([namespace name ] (workflow-template-service-get-workflow-template namespace name nil))
  ([namespace name optional-params]
   (:data (workflow-template-service-get-workflow-template-with-http-info namespace name optional-params))))

(defn workflow-template-service-lint-workflow-template-with-http-info
  ""
  [namespace body ]
  (call-api "/api/v1/workflow-templates/{namespace}/lint" :post
            {:path-params   {"namespace" namespace }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    body
             :content-types ["application/json"]
             :accepts       ["application/json"]
             :auth-names    ["BearerToken"]}))

(defn workflow-template-service-lint-workflow-template
  ""
  [namespace body ]
  (:data (workflow-template-service-lint-workflow-template-with-http-info namespace body)))

(defn workflow-template-service-list-workflow-templates-with-http-info
  ""
  ([namespace ] (workflow-template-service-list-workflow-templates-with-http-info namespace nil))
  ([namespace {:keys [list-optionslabel-selector list-optionsfield-selector list-optionswatch list-optionsallow-watch-bookmarks list-optionsresource-version list-optionsresource-version-match list-optionstimeout-seconds list-optionslimit list-optionscontinue ]}]
   (call-api "/api/v1/workflow-templates/{namespace}" :get
             {:path-params   {"namespace" namespace }
              :header-params {}
              :query-params  {"listOptions.labelSelector" list-optionslabel-selector "listOptions.fieldSelector" list-optionsfield-selector "listOptions.watch" list-optionswatch "listOptions.allowWatchBookmarks" list-optionsallow-watch-bookmarks "listOptions.resourceVersion" list-optionsresource-version "listOptions.resourceVersionMatch" list-optionsresource-version-match "listOptions.timeoutSeconds" list-optionstimeout-seconds "listOptions.limit" list-optionslimit "listOptions.continue" list-optionscontinue }
              :form-params   {}
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    ["BearerToken"]})))

(defn workflow-template-service-list-workflow-templates
  ""
  ([namespace ] (workflow-template-service-list-workflow-templates namespace nil))
  ([namespace optional-params]
   (:data (workflow-template-service-list-workflow-templates-with-http-info namespace optional-params))))

(defn workflow-template-service-update-workflow-template-with-http-info
  ""
  [namespace name body ]
  (call-api "/api/v1/workflow-templates/{namespace}/{name}" :put
            {:path-params   {"namespace" namespace "name" name }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    body
             :content-types ["application/json"]
             :accepts       ["application/json"]
             :auth-names    ["BearerToken"]}))

(defn workflow-template-service-update-workflow-template
  ""
  [namespace name body ]
  (:data (workflow-template-service-update-workflow-template-with-http-info namespace name body)))

