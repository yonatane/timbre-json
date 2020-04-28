# timbre-json

Output all timbre logs as json.
Useful in Kubernetes + Datadog Logs, making all logs single line and the json fields are indexed,
including exception stack traces. 

```clj
[yonatane/timbre-json "0.1.2"]
```

## Usage

```clj
(ns example.core
  (:require [taoensso.timbre :as timbre]
            [yonatane.timbre-json]))
            
(timbre/merge-config!
  {:output-fn yonatane.timbre-json/output-fn}) 
```

## License

Copyright © 2018 Yonatan Elhanan

Distributed under the MIT License.
