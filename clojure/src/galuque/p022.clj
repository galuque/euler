(ns galuque.euler.p022
  (:gen-class)
  (:require [clojure.java.io :as io]
            [clojure.string :as str]
            [clojure.edn :as edn]))

(def names (-> "p022/input.txt"
               io/resource
               slurp
               (str/split #",")
               (as-> input
                     (mapv edn/read-string input))))

(defn ch->value [ch]
  (- (int ch) 64))

(defn name-value [name]
  (reduce + (map ch->value name)))

(defn names-scores [names]
  (->> names
       sort
       (mapv name-value)
       (reduce-kv (fn [acc k val]
                    (+ acc (* (inc k) val)))
                  0)))

(comment
  (time
   (names-scores names))
  ;; "Elapsed time: 52.726121 msecs"
  ;; => 871198282
  )

(defn -main []
  (println (names-scores names)))
