(defproject argoj "3.4.5-0.1.0-SNAPSHOT"
  :description "Data-Oriented, pure Clojure API wrapper for Argo Workflow"
  :url "https://github.com/iomonad/argoj"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :plugins [[lein-marginalia "0.9.1"]]
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [clj-http            "3.12.3"]
                 [cheshire            "5.11.0"]]
  :profiles {:dev {:dependencies   [[org.clojure/tools.namespace "0.3.1"]]
                   :source-paths   ["dev"]
                   :resource-paths ["dev-resources"]}
             :repl-options {:init-ns user}}
  :global-vars {*warn-on-reflection* true})
