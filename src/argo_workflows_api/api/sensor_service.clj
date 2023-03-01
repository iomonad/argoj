(ns argo-workflows-api.api.sensor-service
  (:require [argo-workflows-api.core :refer [call-api check-required-params with-collection-format]])
  (:import (java.io File)))

(defn sensor-service-create-sensor-with-http-info
  ""
  [namespace body ]
  (call-api "/api/v1/sensors/{namespace}" :post
            {:path-params   {"namespace" namespace }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    body
             :content-types ["application/json"]
             :accepts       ["application/json"]
             :auth-names    ["BearerToken"]}))

(defn sensor-service-create-sensor
  ""
  [namespace body ]
  (:data (sensor-service-create-sensor-with-http-info namespace body)))

(defn sensor-service-delete-sensor-with-http-info
  ""
  ([namespace name ] (sensor-service-delete-sensor-with-http-info namespace name nil))
  ([namespace name {:keys [delete-optionsgrace-period-seconds delete-optionspreconditionsuid delete-optionspreconditionsresource-version delete-optionsorphan-dependents delete-optionspropagation-policy delete-optionsdry-run ]}]
   (call-api "/api/v1/sensors/{namespace}/{name}" :delete
             {:path-params   {"namespace" namespace "name" name }
              :header-params {}
              :query-params  {"deleteOptions.gracePeriodSeconds" delete-optionsgrace-period-seconds "deleteOptions.preconditions.uid" delete-optionspreconditionsuid "deleteOptions.preconditions.resourceVersion" delete-optionspreconditionsresource-version "deleteOptions.orphanDependents" delete-optionsorphan-dependents "deleteOptions.propagationPolicy" delete-optionspropagation-policy "deleteOptions.dryRun" (with-collection-format delete-optionsdry-run :multi) }
              :form-params   {}
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    ["BearerToken"]})))

(defn sensor-service-delete-sensor
  ""
  ([namespace name ] (sensor-service-delete-sensor namespace name nil))
  ([namespace name optional-params]
   (:data (sensor-service-delete-sensor-with-http-info namespace name optional-params))))

(defn sensor-service-get-sensor-with-http-info
  ""
  ([namespace name ] (sensor-service-get-sensor-with-http-info namespace name nil))
  ([namespace name {:keys [get-optionsresource-version ]}]
   (call-api "/api/v1/sensors/{namespace}/{name}" :get
             {:path-params   {"namespace" namespace "name" name }
              :header-params {}
              :query-params  {"getOptions.resourceVersion" get-optionsresource-version }
              :form-params   {}
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    ["BearerToken"]})))

(defn sensor-service-get-sensor
  ""
  ([namespace name ] (sensor-service-get-sensor namespace name nil))
  ([namespace name optional-params]
   (:data (sensor-service-get-sensor-with-http-info namespace name optional-params))))

(defn sensor-service-list-sensors-with-http-info
  ""
  ([namespace ] (sensor-service-list-sensors-with-http-info namespace nil))
  ([namespace {:keys [list-optionslabel-selector list-optionsfield-selector list-optionswatch list-optionsallow-watch-bookmarks list-optionsresource-version list-optionsresource-version-match list-optionstimeout-seconds list-optionslimit list-optionscontinue ]}]
   (call-api "/api/v1/sensors/{namespace}" :get
             {:path-params   {"namespace" namespace }
              :header-params {}
              :query-params  {"listOptions.labelSelector" list-optionslabel-selector "listOptions.fieldSelector" list-optionsfield-selector "listOptions.watch" list-optionswatch "listOptions.allowWatchBookmarks" list-optionsallow-watch-bookmarks "listOptions.resourceVersion" list-optionsresource-version "listOptions.resourceVersionMatch" list-optionsresource-version-match "listOptions.timeoutSeconds" list-optionstimeout-seconds "listOptions.limit" list-optionslimit "listOptions.continue" list-optionscontinue }
              :form-params   {}
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    ["BearerToken"]})))

(defn sensor-service-list-sensors
  ""
  ([namespace ] (sensor-service-list-sensors namespace nil))
  ([namespace optional-params]
   (:data (sensor-service-list-sensors-with-http-info namespace optional-params))))

(defn sensor-service-sensors-logs-with-http-info
  ""
  ([namespace ] (sensor-service-sensors-logs-with-http-info namespace nil))
  ([namespace {:keys [name trigger-name grep pod-log-optionscontainer pod-log-optionsfollow pod-log-optionsprevious pod-log-optionssince-seconds pod-log-optionssince-timeseconds pod-log-optionssince-timenanos pod-log-optionstimestamps pod-log-optionstail-lines pod-log-optionslimit-bytes pod-log-optionsinsecure-skip-tls-verify-backend ]}]
   (call-api "/api/v1/stream/sensors/{namespace}/logs" :get
             {:path-params   {"namespace" namespace }
              :header-params {}
              :query-params  {"name" name "triggerName" trigger-name "grep" grep "podLogOptions.container" pod-log-optionscontainer "podLogOptions.follow" pod-log-optionsfollow "podLogOptions.previous" pod-log-optionsprevious "podLogOptions.sinceSeconds" pod-log-optionssince-seconds "podLogOptions.sinceTime.seconds" pod-log-optionssince-timeseconds "podLogOptions.sinceTime.nanos" pod-log-optionssince-timenanos "podLogOptions.timestamps" pod-log-optionstimestamps "podLogOptions.tailLines" pod-log-optionstail-lines "podLogOptions.limitBytes" pod-log-optionslimit-bytes "podLogOptions.insecureSkipTLSVerifyBackend" pod-log-optionsinsecure-skip-tls-verify-backend }
              :form-params   {}
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    ["BearerToken"]})))

(defn sensor-service-sensors-logs
  ""
  ([namespace ] (sensor-service-sensors-logs namespace nil))
  ([namespace optional-params]
   (:data (sensor-service-sensors-logs-with-http-info namespace optional-params))))

(defn sensor-service-update-sensor-with-http-info
  ""
  [namespace name body ]
  (call-api "/api/v1/sensors/{namespace}/{name}" :put
            {:path-params   {"namespace" namespace "name" name }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    body
             :content-types ["application/json"]
             :accepts       ["application/json"]
             :auth-names    ["BearerToken"]}))

(defn sensor-service-update-sensor
  ""
  [namespace name body ]
  (:data (sensor-service-update-sensor-with-http-info namespace name body)))

(defn sensor-service-watch-sensors-with-http-info
  ""
  ([namespace ] (sensor-service-watch-sensors-with-http-info namespace nil))
  ([namespace {:keys [list-optionslabel-selector list-optionsfield-selector list-optionswatch list-optionsallow-watch-bookmarks list-optionsresource-version list-optionsresource-version-match list-optionstimeout-seconds list-optionslimit list-optionscontinue ]}]
   (call-api "/api/v1/stream/sensors/{namespace}" :get
             {:path-params   {"namespace" namespace }
              :header-params {}
              :query-params  {"listOptions.labelSelector" list-optionslabel-selector "listOptions.fieldSelector" list-optionsfield-selector "listOptions.watch" list-optionswatch "listOptions.allowWatchBookmarks" list-optionsallow-watch-bookmarks "listOptions.resourceVersion" list-optionsresource-version "listOptions.resourceVersionMatch" list-optionsresource-version-match "listOptions.timeoutSeconds" list-optionstimeout-seconds "listOptions.limit" list-optionslimit "listOptions.continue" list-optionscontinue }
              :form-params   {}
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    ["BearerToken"]})))

(defn sensor-service-watch-sensors
  ""
  ([namespace ] (sensor-service-watch-sensors namespace nil))
  ([namespace optional-params]
   (:data (sensor-service-watch-sensors-with-http-info namespace optional-params))))

