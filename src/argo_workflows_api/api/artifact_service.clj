(ns argo-workflows-api.api.artifact-service
  (:require [argo-workflows-api.core :refer [call-api check-required-params with-collection-format]])
  (:import (java.io File)))

(defn artifact-service-get-artifact-file-with-http-info
  "Get an artifact."
  [namespace id-discriminator id node-id artifact-name artifact-discriminator ]
  (call-api "/artifact-files/{namespace}/{idDiscriminator}/{id}/{nodeId}/{artifactDiscriminator}/{artifactName}" :get
            {:path-params   {"namespace" namespace "idDiscriminator" id-discriminator "id" id "nodeId" node-id "artifactName" artifact-name "artifactDiscriminator" artifact-discriminator }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types ["application/json"]
             :accepts       ["application/json"]
             :auth-names    ["BearerToken"]}))

(defn artifact-service-get-artifact-file
  "Get an artifact."
  [namespace id-discriminator id node-id artifact-name artifact-discriminator ]
  (:data (artifact-service-get-artifact-file-with-http-info namespace id-discriminator id node-id artifact-name artifact-discriminator)))

(defn artifact-service-get-input-artifact-with-http-info
  "Get an input artifact."
  [namespace name node-id artifact-name ]
  (call-api "/input-artifacts/{namespace}/{name}/{nodeId}/{artifactName}" :get
            {:path-params   {"namespace" namespace "name" name "nodeId" node-id "artifactName" artifact-name }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types ["application/json"]
             :accepts       ["application/json"]
             :auth-names    ["BearerToken"]}))

(defn artifact-service-get-input-artifact
  "Get an input artifact."
  [namespace name node-id artifact-name ]
  (:data (artifact-service-get-input-artifact-with-http-info namespace name node-id artifact-name)))

(defn artifact-service-get-input-artifact-by-uid-with-http-info
  "Get an input artifact by UID."
  [uid node-id artifact-name ]
  (call-api "/input-artifacts-by-uid/{uid}/{nodeId}/{artifactName}" :get
            {:path-params   {"uid" uid "nodeId" node-id "artifactName" artifact-name }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types ["application/json"]
             :accepts       ["application/json"]
             :auth-names    ["BearerToken"]}))

(defn artifact-service-get-input-artifact-by-uid
  "Get an input artifact by UID."
  [uid node-id artifact-name ]
  (:data (artifact-service-get-input-artifact-by-uid-with-http-info uid node-id artifact-name)))

(defn artifact-service-get-output-artifact-with-http-info
  "Get an output artifact."
  [namespace name node-id artifact-name ]
  (call-api "/artifacts/{namespace}/{name}/{nodeId}/{artifactName}" :get
            {:path-params   {"namespace" namespace "name" name "nodeId" node-id "artifactName" artifact-name }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types ["application/json"]
             :accepts       ["application/json"]
             :auth-names    ["BearerToken"]}))

(defn artifact-service-get-output-artifact
  "Get an output artifact."
  [namespace name node-id artifact-name ]
  (:data (artifact-service-get-output-artifact-with-http-info namespace name node-id artifact-name)))

(defn artifact-service-get-output-artifact-by-uid-with-http-info
  "Get an output artifact by UID."
  [uid node-id artifact-name ]
  (call-api "/artifacts-by-uid/{uid}/{nodeId}/{artifactName}" :get
            {:path-params   {"uid" uid "nodeId" node-id "artifactName" artifact-name }
             :header-params {}
             :query-params  {}
             :form-params   {}
             :content-types ["application/json"]
             :accepts       ["application/json"]
             :auth-names    ["BearerToken"]}))

(defn artifact-service-get-output-artifact-by-uid
  "Get an output artifact by UID."
  [uid node-id artifact-name ]
  (:data (artifact-service-get-output-artifact-by-uid-with-http-info uid node-id artifact-name)))

