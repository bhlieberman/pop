(ns hlperetz.pop.core)

(defprotocol ISoql
  (query [this q]))

(extend-protocol ISoql
  clojure.lang.IPersistentMap
  (query [this q]
    (merge-with (fn [l r]
                  (cond
                    (or (nil? l) (nil? r)) r
                    (and (map? r) (map? l)) (merge l r)
                    (and (vector? r) (vector? l)) (concat l r))) this q)))