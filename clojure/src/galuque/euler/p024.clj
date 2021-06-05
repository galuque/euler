(ns galuque.euler.p024
  (:gen-class)
  (:require [clojure.math.combinatorics :as comb]))

(defn nth-permutation [n]
  (apply str (comb/nth-permutation (range 10) n)))

(comment
  (time
   (nth-permutation 999999))
  )

(defn -main [arg]
  (println (nth-permutation (Long/parseLong arg))))
