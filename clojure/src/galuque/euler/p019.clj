(ns galuque.euler.p019
  (:gen-class)
  (:import [java.util GregorianCalendar]))

(defn first-day-sunday? [year month]
  (let [c (doto (GregorianCalendar.)
            (.set GregorianCalendar/YEAR year)
            (.set GregorianCalendar/MONTH month)
            (.set GregorianCalendar/DAY_OF_MONTH 1))]
    (= GregorianCalendar/SUNDAY
       (.get c GregorianCalendar/DAY_OF_WEEK))))

(defn counting-sundays [year]
  (count
   (filter true?
           (for [y  (range 1901 (inc year))
                 m  (range 1 13)]
             (first-day-sunday? y m)))))
(comment
  (counting-sundays 2000)
  )

(defn -main [arg]
  (println (counting-sundays (Long/parseLong arg))))
