(ns galuque.euler.p1
  (:gen-class))

;; fastest
(defn sum [coll]
  (apply + coll))

(defn mults-3  [n] (range 3 n 3))
(defn mults-5  [n] (range 5 n 5))
(defn mults-15 [n] (range 15 n 15))

(defn p1 [n]
  (- (+ (sum (mults-3 n))
        (sum (mults-5 n)))
     (sum (mults-15 n))))

;; Alternate approach using transducers
(defn divides?
  [dividend divisor]
  (zero? (rem dividend divisor)))

(defn divides-any
  [& nums]
  (fn [arg]
    (boolean (some #(divides? arg %) nums))))

(defn problem-1
  ([] (problem-1 1000))
  ([upper]
   (transduce (filter (divides-any 3 5))
              +
              0
              (range upper))))

;; Alternate aproach using a list comprehension
(defn p1-for [upper]
  (let [multiples (for [n     (range upper)
                        :when ((divides-any 3 5) n)]
                    n)]
    (reduce + 0 multiples)))

(defn -main [number]
  (println (p1 (Integer/parseInt number))))
