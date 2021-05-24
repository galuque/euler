(ns p3
  (:gen-class))

(def prime-numbers
  ((fn f [x]
     (cons x
           (lazy-seq
            (f (first
                (drop-while
                 (fn [n]
                   (some #(zero? (mod n %))
                         (take-while #(<= (* % %) n) prime-numbers)))
                 (iterate inc (inc x))))))))
   2))

(defn factorize [n]
  ((fn f [n [h & r :as ps]]
     (cond (< n 2) '()
           (zero? (mod n h)) (cons h (lazy-seq (f (quot n h) ps)))
           :else (recur n r)))
   n prime-numbers))

(defn p3 [n]
  (apply max (factorize n)))

(defn -main [number]
  (println (p3 (Long/parseLong number))))
