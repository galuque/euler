(ns p5
  (:gen-class))

(defn evenly-divisible? [n div]
  (= 0 (mod n div)))

(defn evenly-divisible-range? [n]
  (every? (partial evenly-divisible? n) (range 1 21)))

(def smallest-multiple
  (first
   (filter evenly-divisible-range? (iterate inc 2520))))

(defn -main []
  (println smallest-multiple))