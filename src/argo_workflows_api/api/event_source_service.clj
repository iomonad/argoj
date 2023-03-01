(ns argo-workflows-api.api.event-source-service
  (:require [argo-workflows-api.core :refer [call-api check-required-params with-collection-format]])
  (:import (java.io File)))

(defn event-source-service-create-event-source-with-http-info
  ""
  [namespace body ]
  (call-api "/api/v1/event-sources/{namespace}" :post
            {:path-params   {"namespace" namespace }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    body
             :content-types ["application/json"]
             :accepts       ["application/json"]
             :auth-names    ["BearerToken"]}))

(defn event-source-service-create-event-source
  ""
  [namespace body ]
  (:data (event-source-service-create-event-source-with-http-info namespace body)))

(defn event-source-service-delete-event-source-with-http-info
  ""
  ([namespace name ] (event-source-service-delete-event-source-with-http-info namespace name nil))
  ([namespace name {:keys [delete-optionsgrace-period-seconds delete-optionspreconditionsuid delete-optionspreconditionsresource-version delete-optionsorphan-dependents delete-optionspropagation-policy delete-optionsdry-run ]}]
   (call-api "/api/v1/event-sources/{namespace}/{name}" :delete
             {:path-params   {"namespace" namespace "name" name }
              :header-params {}
              :query-params  {"deleteOptions.gracePeriodSeconds" delete-optionsgrace-period-seconds "deleteOptions.preconditions.uid" delete-optionspreconditionsuid "deleteOptions.preconditions.resourceVersion" delete-optionspreconditionsresource-version "deleteOptions.orphanDependents" delete-optionsorphan-dependents "deleteOptions.propagationPolicy" delete-optionspropagation-policy "deleteOptions.dryRun" (with-collection-format delete-optionsdry-run :multi) }
              :form-params   {}
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    ["BearerToken"]})))

(defn event-source-service-delete-event-source
  ""
  ([namespace name ] (event-source-service-delete-event-source namespace name nil))
  ([namespace name optional-params]
   (:data (event-source-service-delete-event-source-with-http-info namespace name optional-params))))

(defn event-source-service-event-sources-logs-with-http-info
  ""
  ([namespace ] (event-source-service-event-sources-logs-with-http-info namespace nil))
  ([namespace {:keys [name event-source-type event-name grep pod-log-optionscontainer pod-log-optionsfollow pod-log-optionsprevious pod-log-optionssince-seconds pod-log-optionssince-timeseconds pod-log-optionssince-timenanos pod-log-optionstimestamps pod-log-optionstail-lines pod-log-optionslimit-bytes pod-log-optionsinsecure-skip-tls-verify-backend ]}]
   (call-api "/api/v1/stream/event-sources/{namespace}/logs" :get
             {:path-params   {"namespace" namespace }
              :header-params {}
              :query-params  {"name" name "eventSourceType" event-source-type "eventName" event-name "grep" grep "podLogOptions.container" pod-log-optionscontainer "podLogOptions.follow" pod-log-optionsfollow "podLogOptions.previous" pod-log-optionsprevious "podLogOptions.sinceSeconds" pod-log-optionssince-seconds "podLogOptions.sinceTime.seconds" pod-log-optionssince-timeseconds "podLogOptions.sinceTime.nanos" pod-log-optionssince-timenanos "podLogOptions.timestamps" pod-log-optionstimestamps "podLogOptions.tailLines" pod-log-optionstail-lines "podLogOptions.limitBytes" pod-log-optionslimit-bytes "podLogOptions.insecureSkipTLSVerifyBackend" pod-log-optionsinsecure-skip-tls-verify-backend }
              :form-params   {}
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    ["BearerToken"]})))

(defn event-source-service-event-sources-logs
  ""
  ([namespace ] (event-source-service-event-sources-logs namespace nil))
  ([namespace optional-params]
   (:data (event-source-service-event-sources-logs-with-http-info namespace optional-params))))

(defn event-source-service-get-event-source-with-http-info
  ""
  [namespace name ]
  (call-api "/api/v1/event-sources/{namespace}/{name}" :get
            {:path-params   {"namespace" namespace "name" name }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types ["application/json"]
             :accepts       ["application/json"]
             :auth-names    ["BearerToken"]}))

(defn event-source-service-get-event-source
  ""
  [namespace name ]
  (:data (event-source-service-get-event-source-with-http-info namespace name)))

(defn event-source-service-list-event-sources-with-http-info
  ""
  ([namespace ] (event-source-service-list-event-sources-with-http-info namespace nil))
  ([namespace {:keys [list-optionslabel-selector list-optionsfield-selector list-optionswatch list-optionsallow-watch-bookmarks list-optionsresource-version list-optionsresource-version-match list-optionstimeout-seconds list-optionslimit list-optionscontinue ]}]
   (call-api "/api/v1/event-sources/{namespace}" :get
             {:path-params   {"namespace" namespace }
              :header-params {}
              :query-params  {"listOptions.labelSelector" list-optionslabel-selector "listOptions.fieldSelector" list-optionsfield-selector "listOptions.watch" list-optionswatch "listOptions.allowWatchBookmarks" list-optionsallow-watch-bookmarks "listOptions.resourceVersion" list-optionsresource-version "listOptions.resourceVersionMatch" list-optionsresource-version-match "listOptions.timeoutSeconds" list-optionstimeout-seconds "listOptions.limit" list-optionslimit "listOptions.continue" list-optionscontinue }
              :form-params   {}
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    ["BearerToken"]})))

(defn event-source-service-list-event-sources
  ""
  ([namespace ] (event-source-service-list-event-sources namespace nil))
  ([namespace optional-params]
   (:data (event-source-service-list-event-sources-with-http-info namespace optional-params))))

(defn event-source-service-update-event-source-with-http-info
  ""
  [namespace name body ]
  (call-api "/api/v1/event-sources/{namespace}/{name}" :put
            {:path-params   {"namespace" namespace "name" name }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    body
             :content-types ["application/json"]
             :accepts       ["application/json"]
             :auth-names    ["BearerToken"]}))

(defn event-source-service-update-event-source
  ""
  [namespace name body ]
  (:data (event-source-service-update-event-source-with-http-info namespace name body)))

(defn event-source-service-watch-event-sources-with-http-info
  ""
  ([namespace ] (event-source-service-watch-event-sources-with-http-info namespace nil))
  ([namespace {:keys [list-optionslabel-selector list-optionsfield-selector list-optionswatch list-optionsallow-watch-bookmarks list-optionsresource-version list-optionsresource-version-match list-optionstimeout-seconds list-optionslimit list-optionscontinue ]}]
   (call-api "/api/v1/stream/event-sources/{namespace}" :get
             {:path-params   {"namespace" namespace }
              :header-params {}
              :query-params  {"listOptions.labelSelector" list-optionslabel-selector "listOptions.fieldSelector" list-optionsfield-selector "listOptions.watch" list-optionswatch "listOptions.allowWatchBookmarks" list-optionsallow-watch-bookmarks "listOptions.resourceVersion" list-optionsresource-version "listOptions.resourceVersionMatch" list-optionsresource-version-match "listOptions.timeoutSeconds" list-optionstimeout-seconds "listOptions.limit" list-optionslimit "listOptions.continue" list-optionscontinue }
              :form-params   {}
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    ["BearerToken"]})))

(defn event-source-service-watch-event-sources
  ""
  ([namespace ] (event-source-service-watch-event-sources namespace nil))
  ([namespace optional-params]
   (:data (event-source-service-watch-event-sources-with-http-info namespace optional-params))))

