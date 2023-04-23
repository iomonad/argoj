# argoj [![Clojure CI](https://github.com/iomonad/argoj/actions/workflows/clojure.yml/badge.svg)](https://github.com/iomonad/argoj/actions/workflows/clojure.yml) [![Clojars Project](https://img.shields.io/clojars/v/io.trosa/argoj.svg)](https://clojars.org/io.trosa/argoj)

<a href="https://github.com/iomonad/argoj"><img
  src="https://argoproj.github.io/argo-workflows/assets/logo.png"
  height="180" align="right"></a>


## Abstract

> Data-Oriented, pure Clojure API wrapper for Argo Workflow, an open source container-native workflow engine for orchestrating parallel jobs on Kubernetes.

## OpenAPI Stub

Generate OpenAPI stubs for latest version with script:

```bash
/bin/zsh bin/openapi-generate
```

## API Usage

### Client Creation

Create a client spec as follow:

```clojure
(ns user
  (:require [argoj.api :as argo]))

(def client-spec
  (argo/mk-client {:token "xxxx"
                   :endpoint "argo-server.argo.svc.cluster:2746"}))
```

### Submit a Workflow

See [Field Reference](https://argoproj.github.io/argo-workflows/fields/) for all supported field used as EDN

#### Hello World

```clojure
(def spec
  {:namespace "argo"
   :serverDryRun false
   :workflow {:metadata {:namespace "argo"
                         :generateName "foobar-"
                         :labels #:workflows.argoproj.io{:completed "false"}}
              :spec
              {:templates
               [{:name "cowsay"
                 :container {:name "cowsay"
                             :image "docker/whalesay:latest"
                             :command ["cowsay"]
                             :args ["hello world"]
                             :resources {}}}]
               :entrypoint "cowsay"}}})

(argo/create-workflow client "argo" spec)
```

### Search Workflow

Workflows can be selected by their labels:

```clojure
(argo/search-workflows spec "argo" {:initiator "foobar"}) ;; {:metadata {:resourceVersion ...
```

### List Workflows

List workflows, and return their status / results

```clojure
(count (:items (argo/list-workflows client "argo"))) ;; => 1
```

### Delete Workflows

Delete running or completed Workflow

```clojure
(argo/create-workflow client "argo" "foobar-8fu7j")
```

### API

See complete implemented API method [on this documentation page.](https://iomonad.github.io/argoj/#argoj.api)

## Testing

```bash
lein test
```
## Changelog

### 3.4.5-0.3.5-SNAPSHOT

- Added unsafe executor function

### 3.4.5-0.2.0

- API & Spec Implemenations for Jobs, Events, Workflows, WorkflowsTemplate & CronJobs
- Admin routes implemenations

### 3.4.5-0.1.0

- First API Release

## License

Copyright © 2023 iomonad <iomonad@riseup.net>

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
