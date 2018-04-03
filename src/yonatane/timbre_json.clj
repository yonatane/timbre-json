(ns yonatane.timbre-json
  (:require [cheshire.core :as json]
            [taoensso.timbre :as timbre]))


(defn output-fn [data]
  (let [{:keys [level ?err #_vargs msg_ ?ns-str ?file hostname_
                timestamp_ ?line]} data
        output-data (cond->
                      {:timestamp (force timestamp_)
                       :host (force hostname_)
                       :level level
                       :msg (force msg_)}
                      (or ?ns-str ?file) (assoc :ns (or ?ns-str ?file))
                      ?line (assoc :line ?line)
                      ?err (assoc :err (timbre/stacktrace ?err {:stacktrace-fonts {}})))]
    (json/generate-string output-data)))
