(ns argoj.specs
  (:require [clojure.spec.alpha :as s]))

;;%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
;;             Specs
;;%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

;;; Context Spec

(s/def :context/base-url string?)
(s/def :context/date-format string?)
(s/def :context/datetime-format string?)
(s/def :context/debug boolean?)
(s/def :context/auths map?)

(s/def ::context
  (s/keys :req-un [:context/base-url
                   :context/date-format
                   :context/datetime-format
                   :context/debug
                   :context/auths]))
