(ns aoc2018.p02
  (:require [clojure.data :as d]
            [clojure.pprint :as pp]))

(defn checksum [ids]
  (let [c (vals
           (frequencies (flatten
                         (map #(dedupe (filter (fn [c] (or (= 2 c) (= 3 c))) (vals (frequencies %)))) ids))))]
    (apply * c)))

(defn diff [text-a text-b]
  (let [[mine yours common] (d/diff (seq text-a) (seq text-b))]
    {:mine  (filter some? mine)
     :yours (filter some? yours)
     :common (filter some? common)}))

(defn get-diffs [ids]
  (loop [head (first ids)
         tail (rest ids)
         diffs []]
    (if-not (next tail)
      diffs
      (recur (first tail)
             (next tail)
             (apply conj diffs (map #(diff head %) tail))))))

(defn filter-diffs [diffs]
  (->> diffs
       (filter #(= 1 (count(:mine %))))
       first
       :common
       (apply str)))

(defn common-code [ids]
  (->> ids
       get-diffs
       filter-diffs))

(defn -main [& args]
  (println (checksum args))
  (println (common-code args)))
