(ns galuque.euler.p5
  (:gen-class)
  (:require [galuque.euler.utils :as utils]))

(defn smallest-multiple [k]
  (let [primes (take-while #(< % k) (utils/sieve))
        result (reduce
                (fn [acc prime]
                  (let [exponent (Math/floor (/ (Math/log k)
                                                (Math/log prime)))]
                    (* acc (Math/pow prime exponent))))
                1
                primes)]
    (int result)))

(defn -main [arg]
  (println (smallest-multiple (Integer/parseInt arg))))

(comment
  
  (dotimes [_ 3]
    (time
     (smallest-multiple 20)))
  ;; "Elapsed time: 0.168377 msecs"
  ;; "Elapsed time: 0.047399 msecs"
  ;; "Elapsed time: 0.070401 msecs"
)