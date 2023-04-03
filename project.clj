(defproject io.trosa/argoj "3.4.5-0.3.3a"
  :description "Data-Oriented, pure Clojure API wrapper for Argo Workflow"
  :url "https://github.com/iomonad/argoj"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :deploy-repositories [["snapshots" {:url "https://repo.clojars.org"
                                      :username :env/clojars_username
                                      :password :env/clojars_password
                                      :sign-releases false}]
                        ["releases"  {:url "https://repo.clojars.org"
                                      :username :env/clojars_username
                                      :password :env/clojars_password
                                      :sign-releases false}]]
  :plugins [[lein-marginalia "0.9.1"]]
  :dependencies [[org.clojure/clojure       "1.11.1"]
                 [clj-http                  "3.12.3"]
                 [cheshire                  "5.11.0"]
                 [prismatic/schema          "1.4.1"]]
  :profiles {:dev {:dependencies   [[org.clojure/tools.namespace "1.4.2"]]
                   :source-paths   ["dev"]
                   :resource-paths ["dev-resources"]}
             :repl-options {:init-ns user}}
  :global-vars {*warn-on-reflection* true})
