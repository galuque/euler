(ns galuque.euler.p023
  (:gen-class))

(defn proper-divisors [n]
  (filter (fn [d] (zero? (rem n d))) (range 1 n)))

(defn abundant? [n]
  (< n (reduce + (proper-divisors n))))

(defn abundant-nums [n]
  (into (sorted-set) (filter abundant?) (range 1 (inc n))))

(defn abundant-sum? [n abundants]
  (some #(abundants (- n %)) (take-while #(< % n) abundants)))

(defn non-abundant-sum [n]
  (let [abundants (abundant-nums (inc n))]
    (->> (range 1 (inc n))
         (remove #(abundant-sum? % abundants))
         (reduce +))))

(comment
  (time
   (non-abundant-sum 28123))
  ;; "Elapsed time: 19089.62862 msecs"
  ;; => 4179871
  )

(defn -main [arg]
  (println (non-abundant-sum (Long/parseLong arg))))
