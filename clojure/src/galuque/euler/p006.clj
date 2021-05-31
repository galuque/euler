(ns galuque.euler.p006
  (:gen-class)
  (:require [galuque.euler.utils :as u]))

(defn sum-sqr-difference [k]
  (- (u/square-of-sums k)
     (u/sum-of-squares k)))

(comment
  (sum-sqr-difference 100)
  ;; => 25164150
  )

(defn -main [arg]
  (println (sum-sqr-difference (Long/parseLong arg))))
