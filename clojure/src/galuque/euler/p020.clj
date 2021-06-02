(ns galuque.euler.p020
  (:gen-class)
  (:require [galuque.euler.utils :as u :refer [!]]))

(defn ch->digit [ch]
  (Character/digit ch 10))

(defn factorial-digit-sum [num]
  (->> (! num)
       str
       (map ch->digit)
       (reduce +)))

(comment
  (factorial-digit-sum 100)
  ;; => 648
)

(defn -main [arg]
  (println (factorial-digit-sum (Long/parseLong arg))))
