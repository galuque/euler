(ns galuque.euler.p017
  (:gen-class))

(def ^:private first20 ["one" "two" "three" "four" "five"
              "six" "seven" "eight" "nine" "ten"
              "eleven" "twelve" "thirteen" "fourteen" "fifteen"
              "sixteen" "seventeen" "eighteen" "nineteen"])

(def ^:private decs ["" "ten" "twenty" "thirty" "forty" "fifty" "sixty" "seventy" "eighty" "ninety"])

(def ^:private h "hundred")

(def ^:private t "thousand")

(def ^:private a "and")

(defn number->word [n]
  (cond
    (= n 1000)
    (str (nth first20 0) " " t)

    (< n 100)
    (let [q (quot n 10)
          m (mod n 10)
          d (nth decs q)]
      (cond
        (zero? m)
        d
        (< q 2)
        (str (nth first20 (dec (+ m (* 10 q)))))
        :else
        (str d "-" (nth first20 (dec m)))))

    (< n 1000)
    (let [q (quot n 100)
          m (mod n 100)]
      (if (zero? m)
        (str (number->word q) " " h)
        (str h " " a " " (number->word m) "-" (number->word  q))))))

(defn count-words [w]
  (count
   (filter (complement #{\space \-}) w)))

(defn number-letter-counts []
  (let [xf   (comp
              (map number->word)
              (map count-words))
        coll (range 1 1001)]
    (transduce xf + 0 coll)))

(comment
  (number-letter-counts)
  )

(defn -main []
  (println (number-letter-counts)))
