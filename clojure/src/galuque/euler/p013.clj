(ns galuque.euler.p013
  (:gen-class)
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(def input (slurp (io/resource "p013/input.txt")))

(def numbers
  (->> input
      str/split-lines
      (mapv bigint)))

(defn first-n-digits [n number]
  (->> number
       str
       (take n)
       (reduce str)))

(comment
  (first-n-digits 10 (apply + numbers))
)

(defn -main [arg]
  (let [sum (apply + numbers)]
    (println (first-n-digits (Long/parseLong arg) sum))))
