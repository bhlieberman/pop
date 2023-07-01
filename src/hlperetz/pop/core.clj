(ns hlperetz.pop.core)

(defprotocol Query
  (select [this k]
    [this k1 k2]
    [this k1 k2 k3]
    [this k1 k2 k3 & ks])
  (where [this -cond])
  (order-by [this])
  (group [this & [ks]])
  (having [this])
  (limit [this])
  (offset [this n])
  (text [this t])
  (bom [this]))

(extend-protocol Query
  clojure.lang.IPersistentMap
  (select 
    ([this k] (get this k))
    ([this k1 k2] ((juxt k1 k2) this))
    ([this k1 k2 k3] ((juxt k1 k2 k3) this))
    ([this k1 k2 k3 & ks] ((juxt k1 k2 k3 ks) this))))
