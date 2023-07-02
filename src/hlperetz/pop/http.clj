(ns hlperetz.pop.http
  (:require [clj-http.client :as client]))

(defn client
  ([url resource]
   (partial client/get (str url resource)))
  ([url resource {:keys [token username password]}]
   (partial client/get (str url resource) {:headers {:x-app-token token}
                                           :basic-auth [username password]})))

(defn wrap-req
  ([handler]
   (wrap-req handler {}))
  ([handler opts]
   (fn [token username password]
     (->> {:token token
           :username username
           :password password}
          (merge (:query-params opts))
          (handler)))))