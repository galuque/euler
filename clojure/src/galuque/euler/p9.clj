(ns galuque.euler.p9
  (:gen-class))

(defn pythagoran-triple? [a b c]
  (and (< a b c)
       (= (* c c)
          (+ (* a a) (* b b)))))

(defn sums-1000? [a b c]
  (= 1000
     (+ a b c)))

(def special-pythagorean-triplet-product
  (first
   (for [a (range 1 1000)
         b (range a (- 1000 a))
         :let [c (- 1000 a b)]
         :when (and (pythagoran-triple? a b c)
                    (sums-1000? a b c))]
     (* a b c))))

(defn -main []
  (println special-pythagorean-triplet-product))
