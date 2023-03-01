(ns argo-workflows-api.api.event-service
  (:require [argo-workflows-api.core :refer [call-api check-required-params with-collection-format]])
  (:import (java.io File)))

(defn event-service-list-workflow-event-bindings-with-http-info
  ""
  ([namespace ] (event-service-list-workflow-event-bindings-with-http-info namespace nil))
  ([namespace {:keys [list-optionslabel-selector list-optionsfield-selector list-optionswatch list-optionsallow-watch-bookmarks list-optionsresource-version list-optionsresource-version-match list-optionstimeout-seconds list-optionslimit list-optionscontinue ]}]
   (call-api "/api/v1/workflow-event-bindings/{namespace}" :get
             {:path-params   {"namespace" namespace }
              :header-params {}
              :query-params  {"listOptions.labelSelector" list-optionslabel-selector "listOptions.fieldSelector" list-optionsfield-selector "listOptions.watch" list-optionswatch "listOptions.allowWatchBookmarks" list-optionsallow-watch-bookmarks "listOptions.resourceVersion" list-optionsresource-version "listOptions.resourceVersionMatch" list-optionsresource-version-match "listOptions.timeoutSeconds" list-optionstimeout-seconds "listOptions.limit" list-optionslimit "listOptions.continue" list-optionscontinue }
              :form-params   {}
              :content-types ["application/json"]
              :accepts       ["application/json"]
              :auth-names    ["BearerToken"]})))

(defn event-service-list-workflow-event-bindings
  ""
  ([namespace ] (event-service-list-workflow-event-bindings namespace nil))
  ([namespace optional-params]
   (:data (event-service-list-workflow-event-bindings-with-http-info namespace optional-params))))

(defn event-service-receive-event-with-http-info
  ""
  [namespace discriminator body ]
  (call-api "/api/v1/events/{namespace}/{discriminator}" :post
            {:path-params   {"namespace" namespace "discriminator" discriminator }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    body
             :content-types ["application/json"]
             :accepts       ["application/json"]
             :auth-names    ["BearerToken"]}))

(defn event-service-receive-event
  ""
  [namespace discriminator body ]
  (:data (event-service-receive-event-with-http-info namespace discriminator body)))
