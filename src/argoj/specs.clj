(ns argoj.specs
  (:require [schema.core :refer [defschema Str Bool
                                 Keyword] :as s]))

;;%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
;;             Specs
;;%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

;;; Kubernetes

(defschema KubeVCTemplate
  {:metadata {:name Str}
   :spec {:accessModes [Str]
          :resources {(s/optional-key :request) {:storage Str}}}})

(defschema KubeVolumeMount
  {:name Str
   :mountPath Str})

(defschema KubeContainerEnv
  {:name Str
   (s/optional-key :value) Str
   (s/optional-key :valueFrom) {:configMapKeyRef {:name Str
                                                  (s/optional-key :value) Str}}})

(defschema KubeContainerResourcesUnit
  {(s/optional-key :memory) Str
   (s/optional-key :cpu) Str})

(defschema KubeContainerResources
  {(s/optional-key :limits)  KubeContainerResourcesUnit
   (s/optional-key :request) KubeContainerResourcesUnit})

;;; Context

(defschema ArgoContext
  "Context Schema"
  {:base-url Str
   :date-format Str
   :datetime-format Str
   :debug Bool
   :auths {Str Str}})

;;; Workflow

(defschema ArgoWorkflowMetadata
  {Keyword Str})

(defschema ArgoWorkflowParameter
  {:name Str
   (s/optional-key :value) Str})

(defschema ArgoWorkflowArguments
  {:parameters [ArgoWorkflowParameter]})

(defschema ArgoWorkflowInput
  {:parameters [ArgoWorkflowParameter]})

(defschema ArgoWorkflowOuput
  {:parameters [ArgoWorkflowParameter]})

(defschema ArgoContainerSpec
  {:name Str
   :image Str
   :command [Str]
   :args [Str]
   (s/optional-key :resources) KubeContainerResources
   (s/optional-key :volumeMounts) KubeVolumeMount
   (s/optional-key :env) KubeContainerEnv})

(defschema ArgoWorkflow
  "Workflow Schema"
  {:namespace Str
   :serverDryRun Bool
   :workflow
   {:metadata {:generateName Str
               :namespace Str
               :labels {Keyword Str}}
    :spec {:templates
           [{:name Str
             (s/optional-key :arguments) ArgoWorkflowArguments
             (s/optional-key :inputs) ArgoWorkflowInput
             (s/optional-key :outputs) ArgoWorkflowOuput
             (s/optional-key :metadata) ArgoWorkflowMetadata
             :container ArgoContainerSpec}]
           :entrypoint Str
           (s/optional-key :arguments) ArgoWorkflowArguments
           (s/optional-key :volumeClaimTemplates) [KubeVCTemplate]}}})

;;; Contracts

(defschema ArgoWorkflowResubmit
  {:memoized Bool
   :name Str
   :namespace Str
   :parameters [Str]})

(defschema ArgoWorkflowLifecycle
  {:name Str
   :namespace Str})
