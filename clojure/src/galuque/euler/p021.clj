(ns galuque.euler.p021
  (:gen-class))

(defn proper-divisors [n]
  (let [base (filter #(zero? (rem n %)) (range 2 (Math/sqrt n)))]
    (concat '(1) (map #(/ n %) base) base)))

(defn d [n]
  (reduce + (proper-divisors n)))

(defn amicable-numbers-sum [k]
  (let [sums  (for [a     (range 2 k)
                    :let  [b (d a)]
                    :when (and (< a b) (= a (d b)))]
                (+ a b))]
    (reduce + sums)))

(comment
  (time
   (amicable-numbers-sum 10000))
  ;; "Elapsed time: 191.537401 msecs"
  ;; => 31626
  )

(defn -main [arg]
  (println (amicable-numbers-sum (Long/parseLong arg))))
