(ns galuque.euler.p010
  (:gen-class)
  (:require [galuque.euler.utils :as utils]))

(defn primes-under-n [n]
  (take-while #(< % n) (utils/sieve)))

(comment
  (time
   (apply + (primes-under-n 2000000)))
  ;; "Elapsed time: 1236.391263 msecs"
  ;; => 142913828922
)

(defn -main [arg]
  (let [primes (primes-under-n (Long/parseLong arg))
        result (apply + primes)]
    (println result)))
