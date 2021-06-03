(ns galuque.euler.p003
  (:gen-class)
  (:require [galuque.euler.utils :as u]))

(def ^:private primes (u/sieve))

(defn factorize [n] (u/prime-factors n primes))

(defn p3 [n]
  (apply max (factorize n)))

(defn -main [number]
  (println (p3 (Long/parseLong number))))
