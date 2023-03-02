(ns argo-workflows-api.api.workflow-service
  (:require [argo-workflows-api.core :refer [call-api check-required-params with-collection-format]])
  (:import (java.io File)))

(defn workflow-service-create-workflow-with-http-info
  ""
  [namespace body ]
  (call-api "/api/v1/workflows/{namespace}" :post
            {:path-params   {"namespace" namespace }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    body
             :content-types ["application/json"]
             :accepts       ["application/json"]
             :auth-names    ["BearerToken"]}))

(defn workflow-service-create-workflow
  ""
  [namespace body ]
  (:data (workflow-service-create-workflow-with-http-info namespace body)))

(defn workflow-service-delete-workflow-with-http-info
  ""
  ([namespace name ] (workflow-service-delete-workflow-with-http-info namespace name nil))
  ([namespace name {:keys [delete-optionsgrace-period-seconds delete-optionspreconditionsuid delete-optionspreconditionsresource-version delete-optionsorphan-dependents delete-optionspropagation-policy delete-optionsdry-run force ]}]
   (call-api "/api/v1/workflows/{namespace}/{name}" :delete
             {:path-params   {"namespace" namespace "name" name }
              :header-params {}
              :query-params  {"deleteOptions.gracePeriodSeconds" delete-optionsgrace-period-seconds "deleteOptions.preconditions.uid" delete-optionspreconditionsuid "deleteOptions.preconditions.resourceVersion" delete-optionspreconditionsresource-version "deleteOptions.orphanDependents" delete-optionsorphan-dependents "deleteOptions.propagationPolicy" delete-optionspropagation-policy "deleteOptions.dryRun" (with-collection-format delete-optionsdry-run :multi) "force" force }
              :form-params   {}
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    ["BearerToken"]})))

(defn workflow-service-delete-workflow
  ""
  ([namespace name ] (workflow-service-delete-workflow namespace name nil))
  ([namespace name optional-params]
   (:data (workflow-service-delete-workflow-with-http-info namespace name optional-params))))

(defn workflow-service-get-workflow-with-http-info
  ""
  ([namespace name ] (workflow-service-get-workflow-with-http-info namespace name nil))
  ([namespace name {:keys [get-optionsresource-version fields ]}]
   (call-api "/api/v1/workflows/{namespace}/{name}" :get
             {:path-params   {"namespace" namespace "name" name }
              :header-params {}
              :query-params  {"getOptions.resourceVersion" get-optionsresource-version "fields" fields }
              :form-params   {}
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    ["BearerToken"]})))

(defn workflow-service-get-workflow
  ""
  ([namespace name ] (workflow-service-get-workflow namespace name nil))
  ([namespace name optional-params]
   (:data (workflow-service-get-workflow-with-http-info namespace name optional-params))))

(defn workflow-service-lint-workflow-with-http-info
  ""
  [namespace body ]
  (call-api "/api/v1/workflows/{namespace}/lint" :post
            {:path-params   {"namespace" namespace }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    body
             :content-types ["application/json"]
             :accepts       ["application/json"]
             :auth-names    ["BearerToken"]}))

(defn workflow-service-lint-workflow
  ""
  [namespace body ]
  (:data (workflow-service-lint-workflow-with-http-info namespace body)))

(defn workflow-service-list-workflows-with-http-info
  ""
  ([namespace ] (workflow-service-list-workflows-with-http-info namespace nil))
  ([namespace {:keys [list-optionslabel-selector list-optionsfield-selector list-optionswatch list-optionsallow-watch-bookmarks list-optionsresource-version list-optionsresource-version-match list-optionstimeout-seconds list-optionslimit list-optionscontinue fields ]}]
   (call-api "/api/v1/workflows/{namespace}" :get
             {:path-params   {"namespace" namespace }
              :header-params {}
              :query-params  {"listOptions.labelSelector" list-optionslabel-selector "listOptions.fieldSelector" list-optionsfield-selector "listOptions.watch" list-optionswatch "listOptions.allowWatchBookmarks" list-optionsallow-watch-bookmarks "listOptions.resourceVersion" list-optionsresource-version "listOptions.resourceVersionMatch" list-optionsresource-version-match "listOptions.timeoutSeconds" list-optionstimeout-seconds "listOptions.limit" list-optionslimit "listOptions.continue" list-optionscontinue "fields" fields }
              :form-params   {}
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    ["BearerToken"]})))

(defn workflow-service-list-workflows
  ""
  ([namespace ] (workflow-service-list-workflows namespace nil))
  ([namespace optional-params]
   (:data (workflow-service-list-workflows-with-http-info namespace optional-params))))

(defn workflow-service-pod-logs-with-http-info
  "DEPRECATED: Cannot work via HTTP if podName is an empty string. Use WorkflowLogs."
  ([namespace name pod-name ] (workflow-service-pod-logs-with-http-info namespace name pod-name nil))
  ([namespace name pod-name {:keys [log-optionscontainer log-optionsfollow log-optionsprevious log-optionssince-seconds log-optionssince-timeseconds log-optionssince-timenanos log-optionstimestamps log-optionstail-lines log-optionslimit-bytes log-optionsinsecure-skip-tls-verify-backend grep selector ]}]
   (call-api "/api/v1/workflows/{namespace}/{name}/{podName}/log" :get
             {:path-params   {"namespace" namespace "name" name "podName" pod-name }
              :header-params {}
              :query-params  {"logOptions.container" log-optionscontainer "logOptions.follow" log-optionsfollow "logOptions.previous" log-optionsprevious "logOptions.sinceSeconds" log-optionssince-seconds "logOptions.sinceTime.seconds" log-optionssince-timeseconds "logOptions.sinceTime.nanos" log-optionssince-timenanos "logOptions.timestamps" log-optionstimestamps "logOptions.tailLines" log-optionstail-lines "logOptions.limitBytes" log-optionslimit-bytes "logOptions.insecureSkipTLSVerifyBackend" log-optionsinsecure-skip-tls-verify-backend "grep" grep "selector" selector }
              :form-params   {}
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    ["BearerToken"]})))

(defn workflow-service-pod-logs
  "DEPRECATED: Cannot work via HTTP if podName is an empty string. Use WorkflowLogs."
  ([namespace name pod-name ] (workflow-service-pod-logs namespace name pod-name nil))
  ([namespace name pod-name optional-params]
   (:data (workflow-service-pod-logs-with-http-info namespace name pod-name optional-params))))

(defn workflow-service-resubmit-workflow-with-http-info
  ""
  [namespace name body ]
  (call-api "/api/v1/workflows/{namespace}/{name}/resubmit" :put
            {:path-params   {"namespace" namespace "name" name }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    body
             :content-types ["application/json"]
             :accepts       ["application/json"]
             :auth-names    ["BearerToken"]}))

(defn workflow-service-resubmit-workflow
  ""
  [namespace name body ]
  (:data (workflow-service-resubmit-workflow-with-http-info namespace name body)))

(defn workflow-service-resume-workflow-with-http-info
  ""
  [namespace name body ]
  (call-api "/api/v1/workflows/{namespace}/{name}/resume" :put
            {:path-params   {"namespace" namespace "name" name }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    body
             :content-types ["application/json"]
             :accepts       ["application/json"]
             :auth-names    ["BearerToken"]}))

(defn workflow-service-resume-workflow
  ""
  [namespace name body ]
  (:data (workflow-service-resume-workflow-with-http-info namespace name body)))

(defn workflow-service-retry-workflow-with-http-info
  ""
  [namespace name body ]
  (call-api "/api/v1/workflows/{namespace}/{name}/retry" :put
            {:path-params   {"namespace" namespace "name" name }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    body
             :content-types ["application/json"]
             :accepts       ["application/json"]
             :auth-names    ["BearerToken"]}))

(defn workflow-service-retry-workflow
  ""
  [namespace name body ]
  (:data (workflow-service-retry-workflow-with-http-info namespace name body)))

(defn workflow-service-set-workflow-with-http-info
  ""
  [namespace name body ]
  (call-api "/api/v1/workflows/{namespace}/{name}/set" :put
            {:path-params   {"namespace" namespace "name" name }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    body
             :content-types ["application/json"]
             :accepts       ["application/json"]
             :auth-names    ["BearerToken"]}))

(defn workflow-service-set-workflow
  ""
  [namespace name body ]
  (:data (workflow-service-set-workflow-with-http-info namespace name body)))

(defn workflow-service-stop-workflow-with-http-info
  ""
  [namespace name body ]
  (call-api "/api/v1/workflows/{namespace}/{name}/stop" :put
            {:path-params   {"namespace" namespace "name" name }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    body
             :content-types ["application/json"]
             :accepts       ["application/json"]
             :auth-names    ["BearerToken"]}))

(defn workflow-service-stop-workflow
  ""
  [namespace name body ]
  (:data (workflow-service-stop-workflow-with-http-info namespace name body)))

(defn workflow-service-submit-workflow-with-http-info
  ""
  [namespace body ]
  (call-api "/api/v1/workflows/{namespace}/submit" :post
            {:path-params   {"namespace" namespace }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    body
             :content-types ["application/json"]
             :accepts       ["application/json"]
             :auth-names    ["BearerToken"]}))

(defn workflow-service-submit-workflow
  ""
  [namespace body ]
  (:data (workflow-service-submit-workflow-with-http-info namespace body)))

(defn workflow-service-suspend-workflow-with-http-info
  ""
  [namespace name body ]
  (call-api "/api/v1/workflows/{namespace}/{name}/suspend" :put
            {:path-params   {"namespace" namespace "name" name }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    body
             :content-types ["application/json"]
             :accepts       ["application/json"]
             :auth-names    ["BearerToken"]}))

(defn workflow-service-suspend-workflow
  ""
  [namespace name body ]
  (:data (workflow-service-suspend-workflow-with-http-info namespace name body)))

(defn workflow-service-terminate-workflow-with-http-info
  ""
  [namespace name body ]
  (call-api "/api/v1/workflows/{namespace}/{name}/terminate" :put
            {:path-params   {"namespace" namespace "name" name }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    body
             :content-types ["application/json"]
             :accepts       ["application/json"]
             :auth-names    ["BearerToken"]}))

(defn workflow-service-terminate-workflow
  ""
  [namespace name body ]
  (:data (workflow-service-terminate-workflow-with-http-info namespace name body)))

(defn workflow-service-watch-events-with-http-info
  ""
  ([namespace ] (workflow-service-watch-events-with-http-info namespace nil))
  ([namespace {:keys [list-optionslabel-selector list-optionsfield-selector list-optionswatch list-optionsallow-watch-bookmarks list-optionsresource-version list-optionsresource-version-match list-optionstimeout-seconds list-optionslimit list-optionscontinue ]}]
   (call-api "/api/v1/stream/events/{namespace}" :get
             {:path-params   {"namespace" namespace }
              :header-params {}
              :query-params  {"listOptions.labelSelector" list-optionslabel-selector "listOptions.fieldSelector" list-optionsfield-selector "listOptions.watch" list-optionswatch "listOptions.allowWatchBookmarks" list-optionsallow-watch-bookmarks "listOptions.resourceVersion" list-optionsresource-version "listOptions.resourceVersionMatch" list-optionsresource-version-match "listOptions.timeoutSeconds" list-optionstimeout-seconds "listOptions.limit" list-optionslimit "listOptions.continue" list-optionscontinue }
              :form-params   {}
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    ["BearerToken"]})))

(defn workflow-service-watch-events
  ""
  ([namespace ] (workflow-service-watch-events namespace nil))
  ([namespace optional-params]
   (:data (workflow-service-watch-events-with-http-info namespace optional-params))))

(defn workflow-service-watch-workflows-with-http-info
  ""
  ([namespace ] (workflow-service-watch-workflows-with-http-info namespace nil))
  ([namespace {:keys [list-optionslabel-selector list-optionsfield-selector list-optionswatch list-optionsallow-watch-bookmarks list-optionsresource-version list-optionsresource-version-match list-optionstimeout-seconds list-optionslimit list-optionscontinue fields ]}]
   (call-api "/api/v1/workflow-events/{namespace}" :get
             {:path-params   {"namespace" namespace }
              :header-params {}
              :query-params  {"listOptions.labelSelector" list-optionslabel-selector "listOptions.fieldSelector" list-optionsfield-selector "listOptions.watch" list-optionswatch "listOptions.allowWatchBookmarks" list-optionsallow-watch-bookmarks "listOptions.resourceVersion" list-optionsresource-version "listOptions.resourceVersionMatch" list-optionsresource-version-match "listOptions.timeoutSeconds" list-optionstimeout-seconds "listOptions.limit" list-optionslimit "listOptions.continue" list-optionscontinue "fields" fields }
              :form-params   {}
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    ["BearerToken"]})))

(defn workflow-service-watch-workflows
  ""
  ([namespace ] (workflow-service-watch-workflows namespace nil))
  ([namespace optional-params]
   (:data (workflow-service-watch-workflows-with-http-info namespace optional-params))))

(defn workflow-service-workflow-logs-with-http-info
  ""
  ([namespace name ] (workflow-service-workflow-logs-with-http-info namespace name nil))
  ([namespace name {:keys [pod-name log-optionscontainer log-optionsfollow log-optionsprevious log-optionssince-seconds log-optionssince-timeseconds log-optionssince-timenanos log-optionstimestamps log-optionstail-lines log-optionslimit-bytes log-optionsinsecure-skip-tls-verify-backend grep selector ]}]
   (call-api "/api/v1/workflows/{namespace}/{name}/log" :get
             {:path-params   {"namespace" namespace "name" name }
              :header-params {}
              :query-params  {"podName" pod-name "logOptions.container" log-optionscontainer "logOptions.follow" log-optionsfollow "logOptions.previous" log-optionsprevious "logOptions.sinceSeconds" log-optionssince-seconds "logOptions.sinceTime.seconds" log-optionssince-timeseconds "logOptions.sinceTime.nanos" log-optionssince-timenanos "logOptions.timestamps" log-optionstimestamps "logOptions.tailLines" log-optionstail-lines "logOptions.limitBytes" log-optionslimit-bytes "logOptions.insecureSkipTLSVerifyBackend" log-optionsinsecure-skip-tls-verify-backend "grep" grep "selector" selector }
              :form-params   {}
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    ["BearerToken"]})))

(defn workflow-service-workflow-logs
  ""
  ([namespace name ] (workflow-service-workflow-logs namespace name nil))
  ([namespace name optional-params]
   (:data (workflow-service-workflow-logs-with-http-info namespace name optional-params))))
