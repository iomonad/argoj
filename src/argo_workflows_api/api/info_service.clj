(ns argo-workflows-api.api.info-service
  (:require [argo-workflows-api.core :refer [call-api check-required-params with-collection-format]])
  (:import (java.io File)))

(defn info-service-collect-event-with-http-info
  ""
  [body ]
  (call-api "/api/v1/tracking/event" :post
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :body-param    body
             :content-types ["application/json"]
             :accepts       ["application/json"]
             :auth-names    ["BearerToken"]}))

(defn info-service-collect-event
  ""
  [body ]
  (:data (info-service-collect-event-with-http-info body)))

(defn info-service-get-info-with-http-info
  ""
  []
  (call-api "/api/v1/info" :get
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types ["application/json"]
             :accepts       ["application/json"]
             :auth-names    ["BearerToken"]}))

(defn info-service-get-info
  ""
  []
  (:data (info-service-get-info-with-http-info)))

(defn info-service-get-user-info-with-http-info
  ""
  []
  (call-api "/api/v1/userinfo" :get
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types ["application/json"]
             :accepts       ["application/json"]
             :auth-names    ["BearerToken"]}))

(defn info-service-get-user-info
  ""
  []
  (:data (info-service-get-user-info-with-http-info)))

(defn info-service-get-version-with-http-info
  ""
  []
  (call-api "/api/v1/version" :get
            {:path-params   {}
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types ["application/json"]
             :accepts       ["application/json"]
             :auth-names    ["BearerToken"]}))

(defn info-service-get-version
  ""
  []
  (:data (info-service-get-version-with-http-info)))

