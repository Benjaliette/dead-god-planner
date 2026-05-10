import { PlayerCard } from "../../components/PlayerCard";
import { usePlayers } from "./usePlayers";

export function PlayersPage() {
  const { players, loading, error } = usePlayers();

  if (loading) return <p className="text-zinc-400">Chargement...</p>;
  if (error) return <p className="text-red-500">Erreur : {error}</p>;

  return (
    <div className="p-6">
      <h1 className="text-3xl font-bold text-zinc-100 mb-6">
        Dead God Planner
      </h1>
      <div className="grid grid-cols-2 sm:grid-cols-4 lg:grid-cols-6 gap-4">
        {players.map((p) => (
          <PlayerCard key={p.itGame} player={p} />
        ))}
      </div>
    </div>
  );
}
