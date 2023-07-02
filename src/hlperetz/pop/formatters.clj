(ns hlperetz.pop.formatters
  (:refer-clojure :exclude [format])
  #_{:clj-kondo/ignore [:unused-import]}
  (:import [clojure.lang IPersistentMap PersistentVector]))

(defn -format [[l r]] [(type l) (type r)])

(defmulti format -format)

(defmethod format [nil nil] [[_ r]] r)

(comment 
  (ns-unmap *ns* '-format)
  (ns-unmap *ns* 'format)
  (format [nil nil]))