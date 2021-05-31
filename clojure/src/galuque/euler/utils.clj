(ns galuque.euler.utils)

(defn sieve []
  (letfn [(enqueue [sieve n step]
            (let [m (+ n step)]
              (if (sieve m)
                (recur sieve m step)
                (assoc sieve m step))))
          (next-sieve [sieve candidate]
            (if-let [step (sieve candidate)]
              (-> sieve
                  (dissoc candidate)
                  (enqueue candidate step))
              (enqueue sieve candidate (+ candidate candidate))))
          (next-primes [sieve candidate]
            (if (sieve candidate)
              (recur (next-sieve sieve candidate) (+ candidate 2))
              (cons candidate
                    (lazy-seq (next-primes (next-sieve sieve candidate)
                                           (+ candidate 2))))))]
    (cons 2 (lazy-seq (next-primes {} 3)))))

(defn prime-factors [n primes]
  ((fn f [n [h & r :as ps]]
     (cond (< n 2) '()
           (zero? (mod n h)) (cons h (lazy-seq (f (quot n h) ps)))
           :else (recur n r)))
   n primes))

(defn square [n]
  (* n n))

(defn sum-of-squares [n]
  (reduce + (map square (range 1 (inc n)))))

(defn square-of-sums [n]
  (square (reduce + (range 1 (inc n)))))