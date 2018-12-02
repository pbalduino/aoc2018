(ns aoc2018.p02)

(defn checksum [ids]
  (let [c (vals
           (frequencies (flatten
                         (map #(dedupe (filter (fn [c] (or (= 2 c) (= 3 c))) (vals (frequencies %)))) ids))))]
    (apply * c)))

(defn -main [& args]
  (println (checksum args)))
