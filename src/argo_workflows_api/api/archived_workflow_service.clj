(ns argo-workflows-api.api.archived-workflow-service
  (:require [argo-workflows-api.core :refer [call-api check-required-params with-collection-format]])
  (:import (java.io File)))

(defn archived-workflow-service-delete-archived-workflow-with-http-info
  ""
  ([uid ] (archived-workflow-service-delete-archived-workflow-with-http-info uid nil))
  ([uid {:keys [namespace ]}]
   (call-api "/api/v1/archived-workflows/{uid}" :delete
             {:path-params   {"uid" uid }
              :header-params {}
              :query-params  {"namespace" namespace }
              :form-params   {}
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    ["BearerToken"]})))

(defn archived-workflow-service-delete-archived-workflow
  ""
  ([uid ] (archived-workflow-service-delete-archived-workflow uid nil))
  ([uid optional-params]
   (:data (archived-workflow-service-delete-archived-workflow-with-http-info uid optional-params))))

(defn archived-workflow-service-get-archived-workflow-with-http-info
  ""
  ([uid ] (archived-workflow-service-get-archived-workflow-with-http-info uid nil))
  ([uid {:keys [namespace ]}]
   (call-api "/api/v1/archived-workflows/{uid}" :get
             {:path-params   {"uid" uid }
              :header-params {}
              :query-params  {"namespace" namespace }
              :form-params   {}
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    ["BearerToken"]})))

(defn archived-workflow-service-get-archived-workflow
  ""
  ([uid ] (archived-workflow-service-get-archived-workflow uid nil))
  ([uid optional-params]
   (:data (archived-workflow-service-get-archived-workflow-with-http-info uid optional-params))))

(defn archived-workflow-service-list-archived-workflow-label-keys-with-http-info
  ""
  ([] (archived-workflow-service-list-archived-workflow-label-keys-with-http-info nil))
  ([{:keys [namespace ]}]
   (call-api "/api/v1/archived-workflows-label-keys" :get
             {:path-params   {}
              :header-params {}
              :query-params  {"namespace" namespace }
              :form-params   {}
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    ["BearerToken"]})))

(defn archived-workflow-service-list-archived-workflow-label-keys
  ""
  ([] (archived-workflow-service-list-archived-workflow-label-keys nil))
  ([optional-params]
   (:data (archived-workflow-service-list-archived-workflow-label-keys-with-http-info optional-params))))

(defn archived-workflow-service-list-archived-workflow-label-values-with-http-info
  ""
  ([] (archived-workflow-service-list-archived-workflow-label-values-with-http-info nil))
  ([{:keys [list-optionslabel-selector list-optionsfield-selector list-optionswatch list-optionsallow-watch-bookmarks list-optionsresource-version list-optionsresource-version-match list-optionstimeout-seconds list-optionslimit list-optionscontinue namespace ]}]
   (call-api "/api/v1/archived-workflows-label-values" :get
             {:path-params   {}
              :header-params {}
              :query-params  {"listOptions.labelSelector" list-optionslabel-selector "listOptions.fieldSelector" list-optionsfield-selector "listOptions.watch" list-optionswatch "listOptions.allowWatchBookmarks" list-optionsallow-watch-bookmarks "listOptions.resourceVersion" list-optionsresource-version "listOptions.resourceVersionMatch" list-optionsresource-version-match "listOptions.timeoutSeconds" list-optionstimeout-seconds "listOptions.limit" list-optionslimit "listOptions.continue" list-optionscontinue "namespace" namespace }
              :form-params   {}
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    ["BearerToken"]})))

(defn archived-workflow-service-list-archived-workflow-label-values
  ""
  ([] (archived-workflow-service-list-archived-workflow-label-values nil))
  ([optional-params]
   (:data (archived-workflow-service-list-archived-workflow-label-values-with-http-info optional-params))))

(defn archived-workflow-service-list-archived-workflows-with-http-info
  ""
  ([] (archived-workflow-service-list-archived-workflows-with-http-info nil))
  ([{:keys [list-optionslabel-selector list-optionsfield-selector list-optionswatch list-optionsallow-watch-bookmarks list-optionsresource-version list-optionsresource-version-match list-optionstimeout-seconds list-optionslimit list-optionscontinue name-prefix namespace ]}]
   (call-api "/api/v1/archived-workflows" :get
             {:path-params   {}
              :header-params {}
              :query-params  {"listOptions.labelSelector" list-optionslabel-selector "listOptions.fieldSelector" list-optionsfield-selector "listOptions.watch" list-optionswatch "listOptions.allowWatchBookmarks" list-optionsallow-watch-bookmarks "listOptions.resourceVersion" list-optionsresource-version "listOptions.resourceVersionMatch" list-optionsresource-version-match "listOptions.timeoutSeconds" list-optionstimeout-seconds "listOptions.limit" list-optionslimit "listOptions.continue" list-optionscontinue "namePrefix" name-prefix "namespace" namespace }
              :form-params   {}
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    ["BearerToken"]})))

(defn archived-workflow-service-list-archived-workflows
  ""
  ([] (archived-workflow-service-list-archived-workflows nil))
  ([optional-params]
   (:data (archived-workflow-service-list-archived-workflows-with-http-info optional-params))))

(defn archived-workflow-service-resubmit-archived-workflow-with-http-info
  ""
  [uid body ]
  (call-api "/api/v1/archived-workflows/{uid}/resubmit" :put
            {:path-params   {"uid" uid }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    body
             :content-types ["application/json"]
             :accepts       ["application/json"]
             :auth-names    ["BearerToken"]}))

(defn archived-workflow-service-resubmit-archived-workflow
  ""
  [uid body ]
  (:data (archived-workflow-service-resubmit-archived-workflow-with-http-info uid body)))

(defn archived-workflow-service-retry-archived-workflow-with-http-info
  ""
  [uid body ]
  (call-api "/api/v1/archived-workflows/{uid}/retry" :put
            {:path-params   {"uid" uid }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    body
             :content-types ["application/json"]
             :accepts       ["application/json"]
             :auth-names    ["BearerToken"]}))

(defn archived-workflow-service-retry-archived-workflow
  ""
  [uid body ]
  (:data (archived-workflow-service-retry-archived-workflow-with-http-info uid body)))

