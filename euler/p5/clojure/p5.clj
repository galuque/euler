(ns p5
  (:gen-class))

(defn not-divisible? [n div]
  (not= 0 (mod n div)))

(def sieve
  ((fn step [s]
     (lazy-seq
      (cons
       (first s)
       (step
        (filter #(not-divisible? % (first s))
                (rest s))))))
   (iterate inc 2)))

(defn smallest-multiple [k]
  (let [primes (take-while #(< % k) sieve)
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