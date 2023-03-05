(ns argoj.specs
  (:require [schema.core :refer [defschema Str Bool]]))

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
