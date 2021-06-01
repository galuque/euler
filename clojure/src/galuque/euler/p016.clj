(ns galuque.euler.p016
  (:gen-class)
  (:require [galuque.euler.utils :as u :refer [pow]]))

(defn ch->digit [ch]
  (Character/digit ch 10))

(defn power-digit-sum [n exp]
  (let [xf   (map ch->digit)
        coll (str (pow n exp))]
    (transduce xf + coll)))

(comment
  (power-digit-sum 2 1000)
  ;; => 1366
  )

(defn -main [& args]
  (let [[n exp] (mapv #(Long/parseLong %) args)]
    (println (power-digit-sum n exp))))
