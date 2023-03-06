(ns argoj.specs
  (:require [schema.core :refer [defschema Str Bool
                                 Keyword] :as s]))

;;%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
;;             Specs
;;%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

;;; Context

(defschema ArgoContext
  "Context Schema"
  {:base-url Str
   :date-format Str
   :datetime-format Str
   :debug Bool
   :auths {Str Str}})

;;; Workflow

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
             :arguments {}
             :inputs {}
             :outputs {}
             :metadata {}
             :container
             {:name Str
              :image Str
              :command [Str]
              :args [Str]
              :resources {}}}]
           :entrypoint Str
           :arguments {}}}})
