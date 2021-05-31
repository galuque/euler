(ns galuque.euler.p012
  (:gen-class)
  (:require [galuque.euler.utils :as u]))

(def ^:private primes (u/sieve))

(defn factorize [n] (u/prime-factors n primes))

(defn count-divisors [n]
  (->> (factorize n)
       frequencies
       vals
       (map inc)
       (apply *)))

(defn triangle-seq
  ([]
   (triangle-seq 1 2))
  ([current step]
   (lazy-seq (cons current
                   (triangle-seq (+ current step)
                                 (inc step))))))

(defn triangle-num-n-divisors [k]
  (let [triangle-numbers   (triangle-seq)
        more-than-n-div? (fn [n] (< k (count-divisors n)))]
    (first (filter more-than-n-div? triangle-numbers))))

(comment
  (time
   (triangle-num-n-divisors 500))
  ;; "Elapsed time: 293.748546 msecs"
  ;; => 76576500
  )
