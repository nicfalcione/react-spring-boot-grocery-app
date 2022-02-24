import axios from "axios";
import { useEffect, useState } from "react";

const useAxiosFetch = (url) => {
    const [data, setData] = useState([])
    const [fetchError, setFetchError] = useState(null)
    const [isLoading, setIsLoading] = useState(false)

    useEffect(() => {
        let isMounted = true
        const source = axios.CancelToken.source()

        const fetchData = async (url) => {
            setIsLoading(true)
            try {
                const response = await axios.get(url, {
                    cancelToken: source.token
                })

                if (isMounted) {
                    setData(response.data)
                    setFetchError(null)
                }
            } catch (err) {
                if (isMounted) {
                    setFetchError(err.message)
                    setData([])
                }
            } finally {
                isMounted && setIsLoading(false)
            }
        }

        fetchData(url)

        const cleanUp = () => {
            isMounted = false
            source.cancel()
        }

        return cleanUp
    }, [url])

    return { data, fetchError, isLoading }
}

export default useAxiosFetch