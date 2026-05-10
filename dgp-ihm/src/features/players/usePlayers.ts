import { useEffect, useState, type SetStateAction } from "react";
import { apiFetch } from "../../api/client";
import type { Player } from "../../types/player";

export function usePlayers() {
  const [players, setPlayers] = useState<Player[]>([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    apiFetch<Player[]>("/players")
      .then(setPlayers)
      .catch((e: { message: SetStateAction<string | null> }) =>
        setError(e.message),
      )
      .finally(() => setLoading(false));
  }, []);

  return { players, loading, error };
}
